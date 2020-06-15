package com.lwp.merge_datasource.dto.model.inner

import com.fasterxml.jackson.annotation.JsonProperty

data class Campaign(
        val id: Int,
        val name: String,
        @JsonProperty("site_url")
        val siteUrl: String
)