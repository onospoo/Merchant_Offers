package com.lwp.merge_datasource.data

import com.lwp.merge_datasource.data.model.Merchant
import org.springframework.data.jpa.repository.JpaRepository

interface MerchantRepository : JpaRepository<Merchant, Int>