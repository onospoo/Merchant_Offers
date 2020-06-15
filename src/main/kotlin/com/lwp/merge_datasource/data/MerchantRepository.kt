package com.lwp.merge_datasource.data

import com.lwp.merge_datasource.data.model.Merchant
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

interface MerchantRepository : MongoRepository<Merchant, Int> {
}