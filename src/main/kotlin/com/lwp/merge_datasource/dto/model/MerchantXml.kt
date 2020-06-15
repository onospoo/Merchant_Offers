package com.lwp.merge_datasource.dto.model

import com.fasterxml.jackson.annotation.JsonRootName
import com.lwp.merge_datasource.dto.model.inner.MerchantAdvertiser

@JsonRootName(value = "cj-api")
data class MerchantXml(
        val advertisers: List<MerchantAdvertiser>
)