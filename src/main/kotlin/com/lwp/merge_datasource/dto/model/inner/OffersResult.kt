package com.lwp.merge_datasource.dto.model.inner

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

data class OffersResult(
        val status: String,
        val rating: Double,
        @JsonProperty("date_start")
        val dateStart: LocalDateTime,
        val campaign: Campaign,
        @JsonProperty("short_name")
        val shortName: String,
        val exclusive: Boolean,
        val name: String,
        @JsonProperty("date_end")
        val dateEnd: LocalDateTime?,
        val promocode: String,
        val id: Int,
        val regions: List<String>,
        val discount: String?,
        val types: List<Type>,
        val image: String,
        @JsonProperty("frameset_link")
        val framesetLink: String,
        @JsonProperty("goto_link")
        val gotolink: String,
        val species: String,
        val categories: List<OffersCategory>,
        val description: String
)