package com.lwp.merge_datasource.dto.model.inner

data class OffersLink(
        val advertiserId: Int,
        val advertiserName: String,
        val category: String,
        val language: String,
        val description: String,
        val destination: String,
        val promotionEndDate: String,
        val promotionStartDate: String,
        val promotionType: String,
        val couponCode: String,
        val relationshipStatus: String,
        val saleCommission: String,
        val sevenDayEpc: Double,
        val threeMonthEpc: Double,
        val clickUrl: String
)