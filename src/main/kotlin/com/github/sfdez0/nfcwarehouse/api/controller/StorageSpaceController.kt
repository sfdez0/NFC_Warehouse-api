package com.github.sfdez0.nfcwarehouse.api.controller

import com.github.sfdez0.nfcwarehouse.api.dto.StorageSpaceCreateDTO
import com.github.sfdez0.nfcwarehouse.api.dto.StorageSpaceResponseDTO
import com.github.sfdez0.nfcwarehouse.api.service.StorageSpaceService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

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
    fun getAllStorageSpaces(): List<StorageSpaceResponseDTO> = storageSpaceService.getAll()

    /**
     * GET /api/v1/storagespaces/{id}
     */
    @GetMapping("/{id}")
    fun getStorageSpaceById(
        @PathVariable id: Long,
    ): StorageSpaceResponseDTO? = storageSpaceService.get(id)

    /**
     * POST /api/v1/storagespaces
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createStorageSpace(
        @RequestBody dto: StorageSpaceCreateDTO,
    ): StorageSpaceResponseDTO = storageSpaceService.create(dto)
}
