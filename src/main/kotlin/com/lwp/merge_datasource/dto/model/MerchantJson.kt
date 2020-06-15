package com.lwp.merge_datasource.dto.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.lwp.merge_datasource.dto.model.inner.Meta
import com.lwp.merge_datasource.dto.model.inner.MerchantResult


data class MerchantJson(
        val results: List<MerchantResult>,
        @JsonProperty("_meta")
        val meta: Meta
)