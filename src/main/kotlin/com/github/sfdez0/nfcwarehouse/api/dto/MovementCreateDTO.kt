package com.github.sfdez0.nfcwarehouse.api.dto

import java.time.Instant

/**
 * Data payload for creating a new Movement.
 *
 * * This DTO defines the mandatory fields required to register a movement in the system.
 * Note that [itemId] is required to establish the relationship with its
 * parent container.
 */
data class MovementCreateDTO(
    val itemId: Long,
    val storageSpaceId: Long,
    val quantityChanged: Int,
    val description: String?,
)
