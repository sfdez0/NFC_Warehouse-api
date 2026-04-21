package com.github.sfdez0.nfcwarehouse.api.controller

import com.github.sfdez0.nfcwarehouse.api.model.Location
import com.github.sfdez0.nfcwarehouse.api.service.LocationService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * TODO
 */
@RestController
@RequestMapping("/api/v1/locations")
class LocationController(
    private val locationService: LocationService,
) {
    @GetMapping("/{id}")
    fun getLocationById(
        @PathVariable id: Long,
    ): Location? = locationService.findById(id)
}
