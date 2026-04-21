package com.github.sfdez0.nfcwarehouse.api.dto

data class ItemCreateDTO(
    val id: Long?,
    val name: String,
    val quantity: Int,
    val storageSpaceId: Long,
)
