package com.github.sfdez0.nfcwarehouse.api.dto

/**
 * Data payload for creating a new Item.
 *
 * * This DTO defines the mandatory fields required to register an item in the system.
 * Note that [storageSpaceId] is required to establish the relationship with its
 * parent container.
 */
data class ItemCreateDTO(
    val name: String,
    val quantity: Int,
    val storageSpaceId: Long,
)
