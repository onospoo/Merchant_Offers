package com.lwp.merge_datasource

import com.lwp.merge_datasource.data.model.Merchant
import com.lwp.merge_datasource.data.model.Offer
import com.lwp.merge_datasource.dto.mapper.toMerchantEntity
import com.lwp.merge_datasource.dto.mapper.toOffersEntity
import com.lwp.merge_datasource.dto.model.inner.MerchantAdvertiser
import com.lwp.merge_datasource.dto.model.inner.MerchantResult
import com.lwp.merge_datasource.dto.model.inner.OffersLink
import com.lwp.merge_datasource.dto.model.inner.OffersResult
import com.lwp.merge_datasource.providers.MerchantJsonProvider
import com.lwp.merge_datasource.providers.MerchantXmlProvider
import com.lwp.merge_datasource.providers.OffersJsonProvider
import com.lwp.merge_datasource.providers.OffersXmlProvider
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ArgumentsSource
import org.assertj.core.api.Assertions.assertThat


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockKExtension::class)
class TestSourceMapper {

    @DisplayName("Тестирование маппера merchant json")
    @ParameterizedTest
    @ArgumentsSource(MerchantJsonProvider::class)
    fun testMerchantJsonMapper(merchantDto: MerchantResult, merchantEntity: Merchant) {
        val result = merchantDto.toMerchantEntity()

        assertThat(result)
                .usingRecursiveComparison()
                .isEqualTo(merchantEntity)
    }

    @DisplayName("Тестирование маппера offers json")
    @ParameterizedTest
    @ArgumentsSource(OffersJsonProvider::class)
    fun testOffersJsonMapper(offersDto: OffersResult, offersEntity: Offer) {
        val result = offersDto.toOffersEntity()

        assertThat(result)
                .usingRecursiveComparison()
                .isEqualTo(offersEntity)
    }

    @DisplayName("Тестирование маппера merchant xml")
    @ParameterizedTest
    @ArgumentsSource(MerchantXmlProvider::class)
    fun testMerchantXmlMapper(merchantDto: MerchantAdvertiser, merchantEntity: Merchant) {
        val result = merchantDto.toMerchantEntity()

        assertThat(result)
                .usingRecursiveComparison()
                .isEqualTo(merchantEntity)
    }

    @DisplayName("Тестирование маппера offers xml")
    @ParameterizedTest
    @ArgumentsSource(OffersXmlProvider::class)
    fun testOffersXmlMapper(offersDto: OffersLink, offersEntity: Offer) {
        val result = offersDto.toOffersEntity()

        assertThat(result)
                .usingRecursiveComparison()
                .isEqualTo(offersEntity)
    }

}