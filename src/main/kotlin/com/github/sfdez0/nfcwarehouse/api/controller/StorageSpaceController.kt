package com.github.sfdez0.nfcwarehouse.api.controller

import com.github.sfdez0.nfcwarehouse.api.model.StorageSpace
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

/**
 * TODO
 */
@RestController
class StorageSpaceController {
    @GetMapping("/storagespaces/{id}")
    fun getStorageSpace(@PathVariable id: String) : StorageSpace? {
        return null
    }
}