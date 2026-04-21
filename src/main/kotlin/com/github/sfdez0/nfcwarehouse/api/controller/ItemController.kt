package com.github.sfdez0.nfcwarehouse.api.controller

import com.github.sfdez0.nfcwarehouse.api.dto.ItemCreateDTO
import com.github.sfdez0.nfcwarehouse.api.dto.ItemResponseDTO
import com.github.sfdez0.nfcwarehouse.api.service.ItemService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

/**
 * Items Endpoints
 */
@RestController
@RequestMapping("/api/v1/items")
class ItemController(
    private val itemService: ItemService,
) {
    /**
     * GET /api/v1/items
     */
    @GetMapping
    fun getAllItems(): List<ItemResponseDTO> = itemService.getAll()

    /**
     * GET /api/v1/items/{id}
     */
    @GetMapping("/{id}")
    fun getItemById(
        @PathVariable id: Long,
    ): ItemResponseDTO? = itemService.get(id)

    /**
     * POST /api/v1/items
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createItem(
        @RequestBody dto: ItemCreateDTO,
    ): ItemResponseDTO = itemService.create(dto)
}
