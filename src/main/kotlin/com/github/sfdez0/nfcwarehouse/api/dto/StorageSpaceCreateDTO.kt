package com.github.sfdez0.nfcwarehouse.api.dto

/**
 * Data payload for creating a new StorageSpace.
 *
 * * This DTO defines the mandatory fields required to register a storage space in the system.
 * Note that [locationId] is required to establish the relationship with its
 * parent container.
 */
data class StorageSpaceCreateDTO(
    val name: String,
    val nfcTagId: String,
    val locationId: Long,
)
