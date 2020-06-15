package com.lwp.merge_datasource.dto.mapper

import com.lwp.merge_datasource.data.model.Merchant
import com.lwp.merge_datasource.data.model.Offer
import com.lwp.merge_datasource.dto.model.inner.MerchantResult
import com.lwp.merge_datasource.dto.model.inner.OffersResult

fun MerchantResult.toMerchantEntity() =
        Merchant(
                id = this.id,
                name = this.name,
                siteUrl = this.siteUrl,
                status = this.status,
                categories = this.categories.map { it.name }
        )

fun OffersResult.toOffersEntity() =
        Offer(
                id = this.id,
                name = this.name,
                description = this.description,
                category = this.categories.map { it.name },
                startDate = this.dateStart,
                endDate = this.dateEnd,
                type = this.types.first().name,
                promocode = this.promocode,
                discount = this.discount,
                clickUrl = this.gotolink
        )