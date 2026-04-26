package com.github.sfdez0.nfcwarehouse.api.dto

/**
 * Data payload for creating a new Location.
 *
 * * This DTO defines the mandatory fields required to register a location in the system.
 */
class LocationCreateDTO(
    val name: String,
    val description: String?,
)
