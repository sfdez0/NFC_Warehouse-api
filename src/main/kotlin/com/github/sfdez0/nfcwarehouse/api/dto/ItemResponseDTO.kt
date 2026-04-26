package com.github.sfdez0.nfcwarehouse.api.dto

/**
 * Item Response DTO
 *
 * * This DTO flattens the relationship with StorageSpace by providing only the [storageSpaceId]
 * to prevent recursion.
 */
data class ItemResponseDTO(
    val id: Long?,
    val name: String,
    val quantity: Int,
    val storageSpaceId: Long?,
    val movements: List<MovementResponseDTO> = emptyList(),
)
