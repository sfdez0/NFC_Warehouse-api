package com.github.sfdez0.nfcwarehouse.api.service

import com.github.sfdez0.nfcwarehouse.api.model.Item
import com.github.sfdez0.nfcwarehouse.api.repository.ItemRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class ItemService(
    private val itemRepository: ItemRepository,
) {
    fun findById(id: Long): Item =
        itemRepository.findById(id).orElseThrow {
            ResponseStatusException(HttpStatus.NOT_FOUND, "Item not found")
        }

    fun save(item: Item): Item = itemRepository.save(item)
}
