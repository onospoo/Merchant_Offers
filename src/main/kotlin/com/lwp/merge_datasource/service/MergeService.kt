package com.lwp.merge_datasource.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.lwp.merge_datasource.data.MerchantRepository
import com.lwp.merge_datasource.data.model.Merchant
import com.lwp.merge_datasource.data.model.Offer
import com.lwp.merge_datasource.dto.mapper.toMerchantEntity
import com.lwp.merge_datasource.dto.mapper.toOffersEntity
import com.lwp.merge_datasource.dto.model.MerchantJson
import com.lwp.merge_datasource.dto.model.MerchantXml
import com.lwp.merge_datasource.dto.model.OffersJson
import com.lwp.merge_datasource.dto.model.OffersXml
import com.lwp.merge_datasource.exception.BusinessException
import kotlinx.coroutines.ExecutorCoroutineDispatcher
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.awaitAll
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import java.io.File
import java.util.concurrent.ForkJoinPool

@Service
class MergeService(
        @Qualifier("jsonMapper")
        private val jsonMapper: ObjectMapper,
        @Qualifier("xmlMapper")
        private val xmlMapper: XmlMapper,
        private val merchantRepository: MerchantRepository
) {

    fun getMerchantsWithOffers(pageNum: Int, pageSize: Int): List<Merchant> =
            merchantRepository.findAll(PageRequest.of(pageNum, pageSize)).toList()

    fun getMerchantsOffersById(id: Int): List<Offer> =
            merchantRepository
                    .findById(id)
                    .map { it.offers }
                    .orElseThrow {
                        BusinessException("Компании с таким id не существует")
                    }

    fun start() {
//        parseMerchantJson()
//        parseOffersJson()
        parseMerchantXml()
        parseOffersXml()
    }

    private fun parseMerchantJson() {
        val merchantsFile = File("src/main/resources/json/ad-merchant.json").readText()
        val merchants = jsonMapper.readValue(merchantsFile, MerchantJson::class.java)
        merchants.results
                .map {
                    it.toMerchantEntity()
                }
                .map {
                    merchantRepository.save(it)
                }
    }

    private fun parseOffersJson() {
        val offersFile = File("src/main/resources/json/ad-offers.json").readText()
        val offers = jsonMapper.readValue(offersFile, OffersJson::class.java)
        offers.results
                .map { offer ->
                    merchantRepository
                            .findById(offer.campaign.id)
                            .map {
                                it.offers.add(offer.toOffersEntity())
                                merchantRepository.save(it)
                            }
                }
    }

    private fun parseMerchantXml() {
        val merchantsFile = File("src/main/resources/xml/cj-merchant.xml").readText()
        val merchants = xmlMapper.readValue(merchantsFile, MerchantXml::class.java)
    }

    private fun parseOffersXml() {
        val offersFile = File("src/main/resources/xml/cj-offers.xml").readText()
        val offers = xmlMapper.readValue(offersFile, OffersXml::class.java)
    }
}