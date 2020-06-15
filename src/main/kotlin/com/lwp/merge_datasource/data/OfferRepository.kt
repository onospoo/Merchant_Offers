package com.lwp.merge_datasource.data

import com.lwp.merge_datasource.data.model.Offer
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface OfferRepository : JpaRepository<Offer, Int> {
    fun findByCampaignId(campaignId: Int, pageable: Pageable) : List<Offer>
}