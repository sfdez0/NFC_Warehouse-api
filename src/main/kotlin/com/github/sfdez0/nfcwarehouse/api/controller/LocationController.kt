package com.github.sfdez0.nfcwarehouse.api.controller

import com.github.sfdez0.nfcwarehouse.api.dto.LocationResponseDTO
import com.github.sfdez0.nfcwarehouse.api.model.Location
import com.github.sfdez0.nfcwarehouse.api.service.LocationService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

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
    fun getAllLocations(): ResponseEntity<List<LocationResponseDTO>> = ResponseEntity.ok(locationService.getAll())

    /**
     * GET /api/v1/locations/{id}
     */
    @GetMapping("/{id}")
    fun getLocationById(
        @PathVariable id: Long,
    ): ResponseEntity<LocationResponseDTO> {
        val location = locationService.get(id)

        return if (location != null) {
            ResponseEntity.ok(location) // 200 OK
        } else {
            ResponseEntity.notFound().build() // 404 Not Found
        }
    }

    /**
     * POST /api/v1/locations
     */
    @PostMapping
    fun createLocation(
        @RequestBody location: Location,
    ): ResponseEntity<Location> {
        val newLocation = locationService.create(location)

        val uri =
            ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newLocation.id)
                .toUri()

        return ResponseEntity.created(uri).body(newLocation) // 201 Created
    }

    /**
     * DELETE /api/v1/locations/{id}
     */
    @DeleteMapping("/{id}")
    fun deleteLocation(
        @PathVariable id: Long,
    ): ResponseEntity<Unit> =
        if (locationService.delete(id)) {
            ResponseEntity.noContent().build() // 204 No Content
        } else {
            ResponseEntity.notFound().build() // 404 Not Found
        }
}
