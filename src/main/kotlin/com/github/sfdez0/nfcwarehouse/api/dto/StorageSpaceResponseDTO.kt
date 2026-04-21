package com.github.sfdez0.nfcwarehouse.api.dto

data class StorageSpaceResponseDTO(
    val id: Long?,
    val name: String,
    val nfcTagId: String,
    val locationId: Long?,
    val items: List<ItemResponseDTO> = emptyList(),
)
