package com.lwp.merge_datasource.data.model

import com.lwp.merge_datasource.dto.model.inner.MerchantCategory
import com.lwp.merge_datasource.dto.model.inner.Region
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document("merchant")
data class Merchant(
        val id: Int,
        val name: String,
        val siteUrl: String,
        val status: String,
        val categories: List<String>,
        val offers: MutableList<Offer> = mutableListOf()
)