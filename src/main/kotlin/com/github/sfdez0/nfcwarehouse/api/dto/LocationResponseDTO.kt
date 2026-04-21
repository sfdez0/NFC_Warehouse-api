package com.github.sfdez0.nfcwarehouse.api.dto

/**
 * Location Response DTO
 *
 * * This DTO includes a nested list of [storageSpaces] for a complete
 * view of the location contents.
 */
data class LocationResponseDTO(
    val id: Long?,
    val name: String,
    val description: String?,
    val storageSpaces: List<StorageSpaceResponseDTO> = emptyList(),
)
