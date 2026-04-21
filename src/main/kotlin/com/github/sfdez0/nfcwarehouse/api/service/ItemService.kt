package com.github.sfdez0.nfcwarehouse.api.service

import com.github.sfdez0.nfcwarehouse.api.dto.ItemCreateDTO
import com.github.sfdez0.nfcwarehouse.api.dto.ItemResponseDTO
import com.github.sfdez0.nfcwarehouse.api.mapper.toResponse
import com.github.sfdez0.nfcwarehouse.api.model.Item
import com.github.sfdez0.nfcwarehouse.api.repository.ItemRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class ItemService(
    private val itemRepository: ItemRepository,
    private val storageSpaceService: StorageSpaceService,
) {
    /**
     * Retrieves all Items as a [ItemResponseDTO] list.
     *
     * @return A list of all items mapped to their response format.
     */
    fun getAll(): List<ItemResponseDTO> = itemRepository.findAll().map { it.toResponse() }

    /**
     * Retrieves a specific Item by its unique ID and converts it to a [ItemResponseDTO].
     *
     * @param id The unique ID of the item to find.
     * @return The [ItemResponseDTO] if the item exists.
     * @throws ResponseStatusException 404 error if no item is found with the given [id].
     */
    fun get(id: Long): ItemResponseDTO {
        val dto =
            itemRepository.findById(id).orElseThrow {
                ResponseStatusException(HttpStatus.NOT_FOUND, "Item not found")
            }
        return dto.toResponse()
    }

    /**
     * Creates a new Item and associates it with an existing storage space.
     * * This method fetches the required [StorageSpace] entity, maps the incoming
     * [ItemCreateDTO] to a new [Item], and saves it to the database.
     *
     * @param dto The [ItemCreateDTO] object containing the new item's details.
     * @return The [ItemResponseDTO] representing the new item.
     * @throws ResponseStatusException 404 if the storageSpaceId in the [dto] is not found.
     */
    fun create(dto: ItemCreateDTO): ItemResponseDTO {
        val storageSpace = storageSpaceService.getEntity(dto.storageSpaceId)

        val newItem =
            Item(
                name = dto.name,
                quantity = dto.quantity,
                storageSpace = storageSpace,
            )

        val savedItem = itemRepository.save(newItem)

        return savedItem.toResponse()
    }
}
