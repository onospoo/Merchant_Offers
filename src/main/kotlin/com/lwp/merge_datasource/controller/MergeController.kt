package com.lwp.merge_datasource.controller

import com.lwp.merge_datasource.data.model.Merchant
import com.lwp.merge_datasource.data.model.Offer
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@Api("MergeService", description = "Сервис для загрузки данных о компаниях и их предложениях")
@RestController
@RequestMapping("/merchants")
interface MergeController {

    @ApiOperation("Загрузка данных из источников")
    @PostMapping("/load")
    fun startMerging()

    @ApiOperation("Получение всех компаний и предложений")
    @GetMapping("/list")
    fun getAllMerchantsWithOffers(
            @ApiParam("Номер страницы")
            @RequestParam(name = "pageNum", required = false, defaultValue = "0")
            pageNum: Int = 0,

            @ApiParam("Количество записей на странице")
            @RequestParam(name = "pageSize", required = false, defaultValue = "10")
            pageSize: Int = 10
    ): ResponseEntity<List<Merchant>>

    @ApiOperation("Получение всех предложений компании")
    @GetMapping("/{id}/offers")
    fun getMerchantsOffersById(
            @ApiParam("id компании")
            @PathVariable(name = "id", required = true)
            id: Int,

            @ApiParam("Номер страницы")
            @RequestParam(name = "pageNum", required = false, defaultValue = "0")
            pageNum: Int = 0,

            @ApiParam("Количество записей на странице")
            @RequestParam(name = "pageSize", required = false, defaultValue = "10")
            pageSize: Int = 10
    ) : ResponseEntity<List<Offer>>

}