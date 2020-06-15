package com.lwp.merge_datasource.providers

import com.lwp.merge_datasource.data.model.Category
import com.lwp.merge_datasource.data.model.Merchant
import com.lwp.merge_datasource.dto.model.inner.CategoryXml
import com.lwp.merge_datasource.dto.model.inner.MerchantAdvertiser
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import java.util.stream.Stream

class MerchantXmlProvider : ArgumentsProvider {

    override fun provideArguments(p0: ExtensionContext?): Stream<out Arguments> {
        val categoryDto = CategoryXml(
                parent = "TEST_PARENT",
                child = "TEST_CHILD"
        )

        val categoryEntityPar = Category(
                id = 0,
                name = "TEST_PARENT"
        )

        val categoryEntityCh = Category(
                id = 0,
                name = "TEST_CHILD"
        )

        val merchantDto = MerchantAdvertiser(
                advertiserId = 100,
                accountStatus = "TEST_STATUS",
                sevenDayEpc = 107.0,
                threeMonthEpc = 143.0,
                language = "RU",
                advertiserName = "TEST_NAME",
                programUrl = "TEST_PROGRAMURL",
                relationshipStatus = "TEST_RELATION_STATUS",
                networkRank = "TEST_NETWORK_RANK",
                primaryCategory = categoryDto
        )

        val merchantEntity = Merchant(
                id = 100,
                name = "TEST_NAME",
                siteUrl = "TEST_PROGRAMURL",
                status = "TEST_STATUS",
                categories = listOf(categoryEntityPar, categoryEntityCh)
        )

        return Stream.of(Arguments.of(merchantDto, merchantEntity))
    }
}