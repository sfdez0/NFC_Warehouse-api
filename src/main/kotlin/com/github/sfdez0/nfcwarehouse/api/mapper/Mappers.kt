package com.github.sfdez0.nfcwarehouse.api.mapper

import com.github.sfdez0.nfcwarehouse.api.dto.ItemResponseDTO
import com.github.sfdez0.nfcwarehouse.api.dto.LocationResponseDTO
import com.github.sfdez0.nfcwarehouse.api.dto.MovementResponseDTO
import com.github.sfdez0.nfcwarehouse.api.dto.StorageSpaceResponseDTO
import com.github.sfdez0.nfcwarehouse.api.model.Item
import com.github.sfdez0.nfcwarehouse.api.model.Location
import com.github.sfdez0.nfcwarehouse.api.model.Movement
import com.github.sfdez0.nfcwarehouse.api.model.StorageSpace

/**
 * Converts a [Location] entity into a [LocationResponseDTO].
 *
 * This function performs mapping by also converting the internal list
 * of [StorageSpace] entities into their respective DTOs. This ensures
 * that the entire hierarchy is safe for JSON serialization and free
 * from circular references.
 *
 * @return A [LocationResponseDTO] containing the location details and its nested storage spaces.
 */
fun Location.toResponse(): LocationResponseDTO =
    LocationResponseDTO(
        id = this.id,
        name = this.name,
        description = this.description,
        storageSpaces = this.storageSpaces.map { it.toResponse() },
    )

/**
 * Converts a [StorageSpace] entity into a [StorageSpaceResponseDTO].
 *
 * This function performs mapping by also converting the internal list
 * of [Item] entities into their respective DTOs. This ensures
 * that the entire hierarchy is safe for JSON serialization and free
 * from circular references.
 *
 * @return A [StorageSpaceResponseDTO] containing the storage space details and its nested items.
 */
fun StorageSpace.toResponse(): StorageSpaceResponseDTO =
    StorageSpaceResponseDTO(
        id = this.id,
        name = this.name,
        nfcTagId = this.nfcTagId,
        locationId = this.location.id,
        items = this.items.map { it.toResponse() },
    )

/**
 * Converts an [Item] entity into a [ItemResponseDTO].
 *
 * @return A [ItemResponseDTO] containing the item details.
 */
fun Item.toResponse(): ItemResponseDTO =
    ItemResponseDTO(
        id = this.id,
        name = this.name,
        quantity = this.quantity,
        storageSpaceId = this.storageSpace.id,
        movements = this.movements.map { it.toResponse() },
    )

/**
 * Converts a [Movement] entity into a [MovementResponseDTO].
 *
 * @return A [MovementResponseDTO] containing the movement details.
 */
fun Movement.toResponse(): MovementResponseDTO =
    MovementResponseDTO(
        id = this.id,
        itemId = this.item.id,
        storageSpaceId = this.storageSpace.id,
        quantityChanged = this.quantityChanged,
        timestamp = this.timestamp,
        description = this.description,
    )
