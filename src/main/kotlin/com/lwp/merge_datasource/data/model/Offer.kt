package com.lwp.merge_datasource.data.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Offer(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Int = 0,
        val name: String = "",
        val description: String = "",
        @OneToMany(fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
        val category: List<Category> = mutableListOf(),
        val startDate: LocalDateTime = LocalDateTime.now(),
        val endDate: LocalDateTime? = null,
        val campaignId: Int = 0,
        val type: String = "",
        val promocode: String? = "",
        val discount: String? = "",
        val clickUrl: String = ""
)