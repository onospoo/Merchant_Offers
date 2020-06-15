package com.lwp.merge_datasource.providers

import com.lwp.merge_datasource.data.model.Category
import com.lwp.merge_datasource.data.model.Offer
import com.lwp.merge_datasource.dto.model.inner.OffersLink
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import java.time.LocalDateTime
import java.util.stream.Stream

class OffersXmlProvider : ArgumentsProvider {

    override fun provideArguments(p0: ExtensionContext?): Stream<out Arguments> {
        val categoryEntity = Category(
                id = 0,
                name = "TEST_CATEGORY"
        )
        val offerDto = OffersLink(
                advertiserId = 100,
                advertiserName = "TEST_NAME",
                category = "TEST_CATEGORY",
                language = "RU",
                description = "TEST_DESCRIPTION",
                destination = "TEST_DESTINATION",
                promotionEndDate = LocalDateTime.MAX,
                promotionStartDate = LocalDateTime.MIN,
                promotionType = "TEST_TYPE",
                couponCode = "TEST_COUPON",
                relationshipStatus = "TEST_RELATION_STATUS",
                saleCommission = "TEST_COMMISION",
                sevenDayEpc = 10.0,
                threeMonthEpc = 10.0,
                clickUrl = "TEST_CLICKURL"
        )

        val offerEntity = Offer(
                id = 0,
                name = "TEST_DESCRIPTION",
                description = "TEST_DESCRIPTION",
                category = listOf(categoryEntity),
                startDate = LocalDateTime.MIN,
                endDate = LocalDateTime.MAX,
                campaignId = 100,
                type = "TEST_TYPE",
                promocode = "TEST_COUPON",
                discount = "TEST_COMMISION",
                clickUrl = "TEST_CLICKURL"
        )

        return Stream.of(Arguments.of(offerDto, offerEntity))
    }
}