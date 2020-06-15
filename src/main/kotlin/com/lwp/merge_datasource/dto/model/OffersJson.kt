package com.lwp.merge_datasource.dto.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.lwp.merge_datasource.dto.model.inner.Meta
import com.lwp.merge_datasource.dto.model.inner.OffersResult
import org.springframework.data.mongodb.core.mapping.Document

@Document("Offers")
data class OffersJson(
        val results: List<OffersResult>,
        @JsonProperty("_meta")
        val meta: Meta
)