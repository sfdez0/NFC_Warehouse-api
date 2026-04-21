package com.github.sfdez0.nfcwarehouse.api.controller

import com.github.sfdez0.nfcwarehouse.api.dto.LocationResponseDTO
import com.github.sfdez0.nfcwarehouse.api.model.Location
import com.github.sfdez0.nfcwarehouse.api.service.LocationService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

/**
 * Locations Endpoints
 */
@RestController
@RequestMapping("/api/v1/locations")
class LocationController(
    private val locationService: LocationService,
) {
    /**
     * GET /api/v1/locations
     */
    @GetMapping
    fun getAllLocations(): List<LocationResponseDTO> = locationService.getAll()

    /**
     * GET /api/v1/locations/{id}
     */
    @GetMapping("/{id}")
    fun getLocationById(
        @PathVariable id: Long,
    ): LocationResponseDTO? = locationService.get(id)

    /**
     * POST /api/v1/locations
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createLocation(
        @RequestBody location: Location,
    ): Location = locationService.create(location)
}
