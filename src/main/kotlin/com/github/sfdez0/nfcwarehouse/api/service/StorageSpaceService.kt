package com.github.sfdez0.nfcwarehouse.api.service

import com.github.sfdez0.nfcwarehouse.api.model.StorageSpace
import com.github.sfdez0.nfcwarehouse.api.repository.StorageSpaceRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class StorageSpaceService(
    private val storageSpaceRepository: StorageSpaceRepository,
) {
    fun findById(id: Long): StorageSpace =
        storageSpaceRepository.findById(id).orElseThrow {
            ResponseStatusException(HttpStatus.NOT_FOUND, "Storage space not found")
        }

    fun save(storageSpace: StorageSpace): StorageSpace = storageSpaceRepository.save(storageSpace)
}
