package com.github.sfdez0.nfcwarehouse.api.dto

data class LocationResponseDTO(
    val id: Long?,
    val name: String,
    val description: String?,
    val storageSpaces: List<StorageSpaceResponseDTO> = emptyList(),
)
