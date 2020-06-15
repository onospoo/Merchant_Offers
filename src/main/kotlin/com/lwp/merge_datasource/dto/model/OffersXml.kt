package com.lwp.merge_datasource.dto.model

import com.fasterxml.jackson.annotation.JsonRootName
import com.lwp.merge_datasource.dto.model.inner.OffersLink

@JsonRootName("cj-api")
data class OffersXml(
        val links: List<OffersLink>
)