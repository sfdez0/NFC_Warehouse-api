package com.github.sfdez0.nfcwarehouse.api.controller

import com.github.sfdez0.nfcwarehouse.api.dto.ItemCreateDTO
import com.github.sfdez0.nfcwarehouse.api.dto.ItemResponseDTO
import com.github.sfdez0.nfcwarehouse.api.service.ItemService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

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
    fun getAllItems(): ResponseEntity<List<ItemResponseDTO>> = ResponseEntity.ok(itemService.getAll())

    /**
     * GET /api/v1/items/{id}
     */
    @GetMapping("/{id}")
    fun getItemById(
        @PathVariable id: Long,
    ): ResponseEntity<ItemResponseDTO> {
        val item = itemService.get(id)

        return if (item != null) {
            ResponseEntity.ok(item) // 200 OK
        } else {
            ResponseEntity.notFound().build() // 404 Not Found
        }
    }

    /**
     * POST /api/v1/items
     */
    @PostMapping
    fun createItem(
        @RequestBody dto: ItemCreateDTO,
    ): ResponseEntity<ItemResponseDTO> {
        val newItem = itemService.create(dto)

        val uri =
            ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newItem.id)
                .toUri()

        return ResponseEntity.created(uri).body(newItem) // 201 Created
    }

    /**
     * DELETE /api/v1/items/{id}
     */
    @DeleteMapping("/{id}")
    fun deleteItem(
        @PathVariable id: Long,
    ): ResponseEntity<Unit> =
        if (itemService.delete(id)) {
            ResponseEntity.noContent().build() // 204 No Content
        } else {
            ResponseEntity.notFound().build() // 404 Not Found
        }
}
