package com.lwp.merge_datasource.dto.model.inner

data class MerchantCategory(
        val language: String,
        val id: Int,
        val parent: MerchantCategory?,
        val name: String
)