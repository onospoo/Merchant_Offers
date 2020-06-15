package com.lwp.merge_datasource.controller.impl

import com.lwp.merge_datasource.controller.MergeController
import com.lwp.merge_datasource.data.model.Merchant
import com.lwp.merge_datasource.data.model.Offer
import com.lwp.merge_datasource.service.MergeService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController


@RestController
class MergeControllerImpl(private val mergeService: MergeService) : MergeController {

    override fun startMerging() {
        mergeService.start()
    }

    override fun getAllMerchants(pageNum: Int, pageSize: Int): ResponseEntity<List<Merchant>> =
            ResponseEntity.ok(mergeService.getMerchants(pageNum, pageSize))

    override fun getMerchantsOffersById(id: Int, pageNum: Int, pageSize: Int): ResponseEntity<List<Offer>> =
            ResponseEntity.ok(mergeService.getMerchantsOffersById(id, pageNum, pageSize))
}