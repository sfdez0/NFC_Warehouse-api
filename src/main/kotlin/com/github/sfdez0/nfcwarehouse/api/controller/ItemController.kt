package com.github.sfdez0.nfcwarehouse.api.controller

import com.github.sfdez0.nfcwarehouse.api.model.Item
import com.github.sfdez0.nfcwarehouse.api.service.ItemService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * TODO
 */
@RestController
@RequestMapping("/api/v1/items")
class ItemController(
    private val itemService: ItemService,
) {
    @GetMapping("/{id}")
    fun getItemById(
        @PathVariable id: Long,
    ): Item? = itemService.findById(id)
}
