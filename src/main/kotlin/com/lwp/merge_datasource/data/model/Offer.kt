package com.lwp.merge_datasource.data.model

import com.lwp.merge_datasource.dto.model.inner.Type
import java.time.LocalDateTime

data class Offer(
        val id: Int,
        val name: String,
        val description: String,
        val category: List<String>,
        val startDate: LocalDateTime,
        val endDate: LocalDateTime?,
        val type: String,
        val promocode: String?,
        val discount: String?,
        val clickUrl: String
)