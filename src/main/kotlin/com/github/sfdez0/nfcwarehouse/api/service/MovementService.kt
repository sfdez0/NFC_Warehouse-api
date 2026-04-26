package com.github.sfdez0.nfcwarehouse.api.service

import com.github.sfdez0.nfcwarehouse.api.dto.MovementCreateDTO
import com.github.sfdez0.nfcwarehouse.api.dto.MovementResponseDTO
import com.github.sfdez0.nfcwarehouse.api.mapper.toResponse
import com.github.sfdez0.nfcwarehouse.api.model.Item
import com.github.sfdez0.nfcwarehouse.api.model.Movement
import com.github.sfdez0.nfcwarehouse.api.repository.MovementRepository
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.time.Instant

// TODO: Implement final endpoints and DTOs
@Service
class MovementService(
    private val movementRepository: MovementRepository,
    private val itemService: ItemService,
    private val storageSpaceService: StorageSpaceService,
) {
    /**
     * Retrieves all [Movement] as a [MovementResponseDTO] list.
     *
     * @return A list of all movements mapped to their response format.
     */
    fun getAll(): List<MovementResponseDTO> = movementRepository.findAll().map { it.toResponse() }

    /**
     * Retrieves a specific [Movement] by its unique ID and converts it to a [MovementResponseDTO].
     *
     * @param id The unique ID of the movement to find.
     * @return The [MovementResponseDTO] if the movement exists, or null if not found.
     * @throws ResponseStatusException 404 error if no movement is found with the given [id].
     */
    fun get(id: Long): MovementResponseDTO? = movementRepository.findById(id).map { it.toResponse() }.orElse(null)

    /**
     * Creates a new [Movement] and asociates it with an existing item.
     * * This method fetches the required [Item] and [StorageSpace] entities, maps the incoming
     * [MovementCreateDTO] to a new [Movement], and saves it to the database.
     *
     * @param dto The [MovementCreateDTO] object containing the new movement details.
     * @return The [MovementResponseDTO] representing the new movement.
     * @throws ResponseStatusException 404 if the itemId or storageSpaceId in the [dto] is not found.
     */
    fun create(dto: MovementCreateDTO): MovementResponseDTO {
        val item = itemService.getEntity(dto.itemId)
        val storageSpace = storageSpaceService.getEntity(dto.storageSpaceId)

        val newMovement =
            Movement(
                item = item,
                storageSpace = storageSpace,
                quantityChanged = dto.quantityChanged,
                timestamp = Instant.now(),
                description = dto.description,
            )

        val savedMovement = movementRepository.save(newMovement)

        return savedMovement.toResponse()
    }
}
