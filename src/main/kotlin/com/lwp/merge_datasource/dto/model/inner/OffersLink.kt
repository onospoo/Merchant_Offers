package com.lwp.merge_datasource.dto.model.inner

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

data class OffersLink(
        val advertiserId: Int,
        val advertiserName: String,
        val category: String,
        val language: String,
        val description: String,
        val destination: String,
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.S")
        val promotionEndDate: LocalDateTime?,
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.S")
        val promotionStartDate: LocalDateTime,
        val promotionType: String,
        val couponCode: String,
        val relationshipStatus: String,
        val saleCommission: String,
        val sevenDayEpc: Double,
        val threeMonthEpc: Double,
        @JsonProperty("clickUrl")
        val clickUrl: String
)