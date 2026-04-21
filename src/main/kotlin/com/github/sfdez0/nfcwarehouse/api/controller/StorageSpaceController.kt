package com.github.sfdez0.nfcwarehouse.api.controller

import com.github.sfdez0.nfcwarehouse.api.model.StorageSpace
import com.github.sfdez0.nfcwarehouse.api.service.StorageSpaceService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * TODO
 */
@RestController
@RequestMapping("/api/v1/storagespaces")
class StorageSpaceController(
    private val storageSpaceService: StorageSpaceService,
) {
    @GetMapping("/{id}")
    fun getStorageSpaceById(
        @PathVariable id: Long,
    ): StorageSpace? = storageSpaceService.findById(id)
}
