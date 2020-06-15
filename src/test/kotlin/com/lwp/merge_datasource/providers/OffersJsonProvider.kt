package com.lwp.merge_datasource.providers

import com.lwp.merge_datasource.data.model.Category
import com.lwp.merge_datasource.data.model.Offer
import com.lwp.merge_datasource.dto.model.inner.Campaign
import com.lwp.merge_datasource.dto.model.inner.OffersCategory
import com.lwp.merge_datasource.dto.model.inner.OffersResult
import com.lwp.merge_datasource.dto.model.inner.Type
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import java.time.LocalDateTime
import java.util.stream.Stream

class OffersJsonProvider : ArgumentsProvider {

    override fun provideArguments(p0: ExtensionContext?): Stream<out Arguments> {
        val campaignDto = Campaign(
                id = 112,
                name = "TEST_CAMP_NAME",
                siteUrl = "TEST_SITE_URL"
        )
        val categoryDto = OffersCategory(
                id = 17,
                name = "TEST_CAT_NAME"
        )
        val typeDto = Type(
                id = 14,
                name = "TEST_TYPE_NAME"
        )
        val categoryEntity = Category(
                id = 17,
                name = "TEST_CAT_NAME"
        )
        val offersDto = OffersResult(
                status = "TEST_STATUS",
                rating = 10.0,
                dateStart = LocalDateTime.MIN,
                campaign = campaignDto,
                shortName = "TEST_SHORT_NAME",
                exclusive = false,
                name = "TEST_NAME",
                dateEnd = LocalDateTime.MAX,
                promocode = "TEST_PROMOCODE",
                id = 1784,
                regions = listOf("RU"),
                discount = "TEST_DISCOUNT",
                types = listOf(typeDto),
                image = "TEST_IMAGE",
                framesetLink = "TEST_FRAME_LINK",
                gotolink = "TEST_GOTOLINK",
                species = "TEST_SPECIES",
                categories = listOf(categoryDto),
                description = "TEST_DESCRIPTION"
        )

        val offerEntity = Offer(
                id = 1784,
                name = "TEST_NAME",
                description = "TEST_DESCRIPTION",
                category = listOf(categoryEntity),
                startDate = LocalDateTime.MIN,
                endDate = LocalDateTime.MAX,
                campaignId = 112,
                type = "TEST_TYPE_NAME",
                promocode = "TEST_PROMOCODE",
                discount = "TEST_DISCOUNT",
                clickUrl = "TEST_GOTOLINK"
        )

        return Stream.of(Arguments.of(offersDto, offerEntity))
    }
}