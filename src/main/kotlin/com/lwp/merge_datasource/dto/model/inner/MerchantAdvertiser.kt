package com.lwp.merge_datasource.dto.model.inner

import com.lwp.merge_datasource.dto.model.inner.CategoryXml

data class MerchantAdvertiser(
        val advertiserId: Int,
        val accountStatus: String,
        val sevenDayEpc: Double,
        val threeMonthEpc: Double,
        val language: String,
        val advertiserName: String,
        val programUrl: String,
        val relationshipStatus: String,
        val networkRank: String,
        val primaryCategory: CategoryXml
)