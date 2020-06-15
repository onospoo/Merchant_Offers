package com.lwp.merge_datasource.dto.model.inner

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class MerchantResult(
        @JsonProperty("goto_cookie_lifetime")
        val gotoCookieLifetime: Int,
        val rating: Double,
        val image: String,
        val currency: String,
        @JsonProperty("activation_date")
        val activationDate: LocalDateTime,
        val id: Int,
        @JsonProperty("connection_status")
        val connectionStatus: String,
        val gotolink: String,
        @JsonProperty("site_url")
        val siteUrl: String,
//        val regions: List<Region>,
        val status: String,
        val description: String,
        @JsonProperty("modified_date")
        val modifiedDate: LocalDateTime?,
        val categories: List<MerchantCategory>,
        val name: String
)