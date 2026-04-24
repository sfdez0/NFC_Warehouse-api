package com.github.sfdez0.nfcwarehouse.api.service

import com.github.sfdez0.nfcwarehouse.api.dto.StorageSpaceCreateDTO
import com.github.sfdez0.nfcwarehouse.api.dto.StorageSpaceResponseDTO
import com.github.sfdez0.nfcwarehouse.api.mapper.toResponse
import com.github.sfdez0.nfcwarehouse.api.model.Location
import com.github.sfdez0.nfcwarehouse.api.model.StorageSpace
import com.github.sfdez0.nfcwarehouse.api.repository.StorageSpaceRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class StorageSpaceService(
    private val storageSpaceRepository: StorageSpaceRepository,
    private val locationService: LocationService,
) {
    /**
     * Retrieves all [StorageSpace] as a [StorageSpaceResponseDTO] list.
     *
     * @return A list of all storage spaces mapped to their response format.
     */
    fun getAll(): List<StorageSpaceResponseDTO> = storageSpaceRepository.findAll().map { it.toResponse() }

    /**
     * Retrieves a specific [StorageSpace] by its unique ID and converts it to a [StorageSpaceResponseDTO].
     *
     * @param id The unique ID of the storage space to find.
     * @return The [StorageSpaceResponseDTO] if the storage space exists.
     * @throws ResponseStatusException 404 error if no storage space is found with the given [id].
     */
    fun get(id: Long): StorageSpaceResponseDTO? = storageSpaceRepository.findById(id).map { it.toResponse() }.orElse(null)

    /**
     * Retrieves a specific [StorageSpace] by its unique ID.
     *
     * @param id The unique ID of the storage space to find.
     * @return The [StorageSpace] if the storage space exists.
     * @throws ResponseStatusException 404 error if no storage space is found with the given [id].
     */
    fun getEntity(id: Long): StorageSpace =
        storageSpaceRepository.findById(id).orElseThrow {
            ResponseStatusException(HttpStatus.NOT_FOUND, "Storage Space not found")
        }

    /**
     * Creates a new [StorageSpace] and associates it with an existing location.
     * * This method fetches the required [Location] entity, maps the incoming
     * [StorageSpaceCreateDTO] to a new [StorageSpace], and saves it to the database.
     *
     * @param dto The [StorageSpaceCreateDTO] object containing the new storage space details.
     * @return The [StorageSpaceResponseDTO] representing the new storage space.
     * @throws ResponseStatusException 404 if the locationId in the [dto] is not found.
     */
    fun create(dto: StorageSpaceCreateDTO): StorageSpaceResponseDTO {
        val location = locationService.getEntity(dto.locationId)

        val newStorageSpace =
            StorageSpace(
                name = dto.name,
                nfcTagId = dto.nfcTagId,
                location = location,
            )

        val savedStorageSpace = storageSpaceRepository.save(newStorageSpace)

        return savedStorageSpace.toResponse()
    }

    /**
     * Deletes an [StorageSpace] by its unique ID.
     * * This method checks if the [StorageSpace] exists and tries to delete it
     *
     * @param id The unique ID of the storage space to delete.
     * @return true if the storage space was deleted, false otherwise.
     */
    fun delete(id: Long): Boolean {
        if (!storageSpaceRepository.existsById(id)) return false

        storageSpaceRepository.deleteById(id)
        return true
    }
}
