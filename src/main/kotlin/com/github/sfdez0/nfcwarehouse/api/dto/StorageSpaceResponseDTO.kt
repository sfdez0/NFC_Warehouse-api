package com.github.sfdez0.nfcwarehouse.api.dto

/**
 * StorageSpace Response DTO
 *
 * * This DTO flattens the relationship with Location by providing only the [locationId]
 * to prevent recursion, while including a nested list of [items] for a complete
 * view of the space's contents.
 */
data class StorageSpaceResponseDTO(
    val id: Long?,
    val name: String,
    val nfcTagId: String,
    val locationId: Long?,
    val items: List<ItemResponseDTO> = emptyList(),
)
