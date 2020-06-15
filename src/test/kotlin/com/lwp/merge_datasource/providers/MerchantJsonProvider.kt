package com.lwp.merge_datasource.providers

import com.lwp.merge_datasource.data.model.Category
import com.lwp.merge_datasource.data.model.Merchant
import com.lwp.merge_datasource.dto.model.inner.MerchantCategory
import com.lwp.merge_datasource.dto.model.inner.MerchantResult
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import java.time.LocalDateTime
import java.util.stream.Stream

class MerchantJsonProvider : ArgumentsProvider {

    override fun provideArguments(p0: ExtensionContext?): Stream<out Arguments> {
        val merchantDtoCategory = MerchantCategory(
                language = "RU",
                id = 555,
                parent = null,
                name = "TEST_CAT_NAME"
        )

        val merchantEntityCategory = Category(
                id = 555,
                name = "TEST_CAT_NAME"
        )

        val merchantDto = MerchantResult(
                gotoCookieLifetime = 100,
                rating = 10.0,
                image = "TEST_IMAGE",
                currency = "TEST_CURRENCY",
                activationDate = LocalDateTime.MIN,
                id = 100,
                connectionStatus = "TEST_CONNECTION_STATUS",
                gotolink = "TEST_GOTOLINK",
                siteUrl = "TEST_SITEURL",
                status = "TEST_STATUS",
                description = "TEST_DESCRIPTION",
                modifiedDate = LocalDateTime.MIN,
                categories = listOf(merchantDtoCategory),
                name = "TEST_NAME"
        )
        val merchantEntity = Merchant(
                id = 100,
                name = "TEST_NAME",
                siteUrl = "TEST_SITEURL",
                status = "TEST_STATUS",
                categories = listOf(merchantEntityCategory)
        )

        return Stream.of(Arguments.of(merchantDto, merchantEntity))
    }
}