package com.github.sfdez0.nfcwarehouse.api.dto

import java.time.Instant

/**
 * Movement Response DTO
 *
 * * This DTO flattens the relationship with Item by providing only the [itemId]
 * to prevent recursion.
 */
class MovementResponseDTO(
    val id: Long?,
    val itemId: Long?,
    val storageSpaceId: Long?,
    val quantityChanged: Int,
    val timestamp: Instant,
    val description: String?,
)
