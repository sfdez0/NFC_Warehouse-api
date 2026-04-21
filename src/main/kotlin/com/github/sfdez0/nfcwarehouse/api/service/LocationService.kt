package com.github.sfdez0.nfcwarehouse.api.service

import com.github.sfdez0.nfcwarehouse.api.model.Location
import com.github.sfdez0.nfcwarehouse.api.repository.LocationRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class LocationService(
    private val locationRepository: LocationRepository,
) {
    fun findById(id: Long): Location =
        locationRepository.findById(id).orElseThrow {
            ResponseStatusException(HttpStatus.NOT_FOUND, "Location not found")
        }

    fun save(location: Location): Location = locationRepository.save(location)
}
