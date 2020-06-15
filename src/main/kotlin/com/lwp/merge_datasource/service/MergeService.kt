package com.lwp.merge_datasource.service

//import com.lwp.merge_datasource.data.MerchantRepository
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.lwp.merge_datasource.data.MerchantRepository
import com.lwp.merge_datasource.data.OfferRepository
import com.lwp.merge_datasource.data.model.Merchant
import com.lwp.merge_datasource.data.model.Offer
import com.lwp.merge_datasource.dto.mapper.toMerchantEntity
import com.lwp.merge_datasource.dto.mapper.toOffersEntity
import com.lwp.merge_datasource.dto.model.MerchantJson
import com.lwp.merge_datasource.dto.model.MerchantXml
import com.lwp.merge_datasource.dto.model.OffersJson
import com.lwp.merge_datasource.dto.model.OffersXml
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.runBlocking
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.io.File

@Service
class MergeService(
        @Qualifier("jsonMapper")
        private val jsonMapper: ObjectMapper,
        @Qualifier("xmlMapper")
        private val xmlMapper: XmlMapper,
        private val merchantRepository: MerchantRepository,
        private val offerRepository: OfferRepository
) {

    @Transactional
    fun getMerchants(pageNum: Int, pageSize: Int): List<Merchant> =
            merchantRepository.findAll(PageRequest.of(pageNum, pageSize)).toList()

    @Transactional
    fun getMerchantsOffersById(id: Int, pageNum: Int, pageSize: Int): List<Offer> =
            offerRepository
                    .findByCampaignId(id, PageRequest.of(pageNum, pageSize))

    fun start() {
        runBlocking(Dispatchers.Default) {
            awaitAll(
                    async { parseMerchantJson() },
                    async { parseOffersJson() },
                    async { parseMerchantXml() },
                    async { parseOffersXml() }
            )
        }
    }

    private suspend fun parseMerchantJson() {
        logger.info { "Началась загрузка Merchant из json" }
        val merchantsFile = File("src/main/resources/json/ad-merchant.json").readText()
        val merchants = jsonMapper.readValue(merchantsFile, MerchantJson::class.java)
        merchants.results
                .map {
                    val merchantEntity = it.toMerchantEntity()
                    merchantRepository.save(merchantEntity)
                }
        logger.info { "Загрузка Merchant из json завершена" }
    }

    private suspend fun parseOffersJson() {
        logger.info { "Началась загрузка Offers из json" }
        val offersFile = File("src/main/resources/json/ad-offers.json").readText()
        val offers = jsonMapper.readValue(offersFile, OffersJson::class.java)
        offers.results
                .map { offer ->
                    val offerEntity = offer.toOffersEntity()
                    offerRepository.save(offerEntity)
                }
        logger.info { "Загрузка Offers из json завершена" }
    }

    private suspend fun parseMerchantXml() {
        logger.info { "Началась загрузка Merchant из json" }
        val merchantsFile = File("src/main/resources/xml/cj-merchant.xml").readText()
        val merchants = xmlMapper.readValue(merchantsFile, MerchantXml::class.java)
        merchants.advertisers
                .map {
                    val merchantEntity = it.toMerchantEntity()
                    merchantRepository.save(merchantEntity)
                }
        logger.info { "Загрузка Merchant из json завершена" }
    }

    private suspend  fun parseOffersXml() {
        logger.info { "Началась загрузка Offers из xml" }
        val offersFile = File("src/main/resources/xml/cj-offers.xml").readText()
        val offers = xmlMapper.readValue(offersFile, OffersXml::class.java)
        offers.links
                .map { offer ->
                    val offerEntity = offer.toOffersEntity()
                    offerRepository.save(offerEntity)
                }
        logger.info { "Загрузка Offers из xml завершена" }
    }

    companion object {
        val logger = KotlinLogging.logger{}
    }
}