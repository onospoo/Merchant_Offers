package com.lwp.merge_datasource.data.model

import javax.persistence.*

@Entity
data class Merchant(
        @Id
        val id: Int = 0,
        val name: String = "",
        val siteUrl: String = "",
        val status: String = "",
        @OneToMany(fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
        val categories: List<Category> = mutableListOf()
)