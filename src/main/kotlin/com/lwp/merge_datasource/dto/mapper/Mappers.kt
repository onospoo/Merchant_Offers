package com.lwp.merge_datasource.dto.mapper

import com.lwp.merge_datasource.data.model.Category
import com.lwp.merge_datasource.data.model.Merchant
import com.lwp.merge_datasource.data.model.Offer
import com.lwp.merge_datasource.dto.model.inner.MerchantAdvertiser
import com.lwp.merge_datasource.dto.model.inner.MerchantResult
import com.lwp.merge_datasource.dto.model.inner.OffersLink
import com.lwp.merge_datasource.dto.model.inner.OffersResult

fun MerchantResult.toMerchantEntity() =
        Merchant(
                id = this.id,
                name = this.name,
                siteUrl = this.siteUrl,
                status = this.status,
                categories = this.categories.map {
                    Category(
                            id = it.id,
                            name = it.name
                    )
                }
        )

fun OffersResult.toOffersEntity() =
        Offer(
                id = this.id,
                name = this.name,
                campaignId = this.campaign.id,
                description = this.description,
                category = this.categories.map {
                    Category(
                            id = it.id,
                            name = it.name
                    )
                },
                startDate = this.dateStart,
                endDate = this.dateEnd,
                type = this.types.first().name,
                promocode = this.promocode,
                discount = this.discount,
                clickUrl = this.gotolink
        )

fun MerchantAdvertiser.toMerchantEntity() =
        Merchant(
                id = this.advertiserId,
                name = this.advertiserName ?: "",
                siteUrl = this.programUrl,
                status = this.accountStatus,
                categories = listOf(
                        this.primaryCategory.parent, 
                        this.primaryCategory.child
                        )
                        .map { Category(name = it) }
        )

fun OffersLink.toOffersEntity() =
        Offer(
                name = this.description,
                campaignId = this.advertiserId,
                description = this.description,
                category = listOf(Category(name = this.category)),
                startDate = this.promotionStartDate,
                endDate = this.promotionEndDate,
                type = this.promotionType,
                promocode = this.couponCode,
                discount = this.saleCommission,
                clickUrl = this.clickUrl
        )