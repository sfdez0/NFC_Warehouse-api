package com.github.sfdez0.nfcwarehouse.api.dto

data class ItemResponseDTO(
    val id: Long?,
    val name: String,
    val quantity: Int,
    val storageSpaceId: Long?,
)
