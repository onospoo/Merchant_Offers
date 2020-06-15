package com.lwp.merge_datasource.dto.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.lwp.merge_datasource.dto.model.inner.Meta
import com.lwp.merge_datasource.dto.model.inner.OffersResult

data class OffersJson(
        val results: List<OffersResult>,
        @JsonProperty("_meta")
        val meta: Meta
)