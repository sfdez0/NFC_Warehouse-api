package com.github.sfdez0.nfcwarehouse.api.controller

import com.github.sfdez0.nfcwarehouse.api.dto.StorageSpaceCreateDTO
import com.github.sfdez0.nfcwarehouse.api.dto.StorageSpaceResponseDTO
import com.github.sfdez0.nfcwarehouse.api.service.StorageSpaceService
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
 * StorageSpaces Endpoints
 */
@RestController
@RequestMapping("/api/v1/storagespaces")
class StorageSpaceController(
    private val storageSpaceService: StorageSpaceService,
) {
    /**
     * GET /api/v1/storagespaces
     */
    @GetMapping
    fun getAllStorageSpaces(): ResponseEntity<List<StorageSpaceResponseDTO>> = ResponseEntity.ok(storageSpaceService.getAll())

    /**
     * GET /api/v1/storagespaces/{id}
     */
    @GetMapping("/{id}")
    fun getStorageSpaceById(
        @PathVariable id: Long,
    ): ResponseEntity<StorageSpaceResponseDTO> {
        val item = storageSpaceService.get(id)

        return if (item != null) {
            ResponseEntity.ok(item) // 200 OK
        } else {
            ResponseEntity.notFound().build() // 404 Not Found
        }
    }

    /**
     * POST /api/v1/storagespaces
     */
    @PostMapping
    fun createStorageSpace(
        @RequestBody dto: StorageSpaceCreateDTO,
    ): ResponseEntity<StorageSpaceResponseDTO> {
        val newStorageSpace = storageSpaceService.create(dto)

        val uri =
            ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newStorageSpace.id)
                .toUri()

        return ResponseEntity.created(uri).body(newStorageSpace) // 201 Created
    }

    /**
     * DELETE /api/v1/storagespaces/{id}
     */
    @DeleteMapping("/{id}")
    fun deleteStorageSpace(
        @PathVariable id: Long,
    ): ResponseEntity<Unit> =
        if (storageSpaceService.delete(id)) {
            ResponseEntity.noContent().build() // 204 No Content
        } else {
            ResponseEntity.notFound().build() // 404 Not Found
        }
}
