package com.github.sfdez0.nfcwarehouse.api.dto

data class StorageSpaceCreateDTO(
    val name: String,
    val nfcTagId: String,
    val locationId: Long,
)
