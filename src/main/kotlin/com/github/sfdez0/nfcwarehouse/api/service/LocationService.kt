package com.github.sfdez0.nfcwarehouse.api.service

import com.github.sfdez0.nfcwarehouse.api.dto.LocationResponseDTO
import com.github.sfdez0.nfcwarehouse.api.mapper.toResponse
import com.github.sfdez0.nfcwarehouse.api.model.Location
import com.github.sfdez0.nfcwarehouse.api.repository.LocationRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class LocationService(
    private val locationRepository: LocationRepository,
) {
    /**
     * Retrieves all [Location] as a [LocationResponseDTO] list.
     *
     * @return A list of all locations mapped to their response format.
     */
    fun getAll(): List<LocationResponseDTO> = locationRepository.findAll().map { it.toResponse() }

    /**
     * Retrieves a specific [Location] by its unique ID and converts it to a [LocationResponseDTO].
     *
     * @param id The unique ID of the location to find.
     * @return The [LocationResponseDTO] if the location exists, or null if not found.
     * @throws ResponseStatusException 404 error if no location is found with the given [id].
     */
    fun get(id: Long): LocationResponseDTO? = locationRepository.findById(id).map { it.toResponse() }.orElse(null)

    /**
     * Retrieves a specific [Location] by its unique ID.
     *
     * @param id The unique ID of the location to find.
     * @return The [Location] if the location exists.
     * @throws ResponseStatusException 404 error if no location is found with the given [id].
     */
    fun getEntity(id: Long): Location =
        locationRepository.findById(id).orElseThrow {
            ResponseStatusException(HttpStatus.NOT_FOUND, "Storage Space not found")
        }

    /**
     * Creates a new [Location].
     *
     * @param location The [Location] entity to create and save.
     * @return The [Location] including its database-generated ID.
     */
    fun create(location: Location): Location = locationRepository.save(location)
}
