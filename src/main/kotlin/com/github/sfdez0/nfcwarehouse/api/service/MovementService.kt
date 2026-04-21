package com.github.sfdez0.nfcwarehouse.api.service

import com.github.sfdez0.nfcwarehouse.api.model.Movement
import com.github.sfdez0.nfcwarehouse.api.repository.MovementRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

// TODO: Implement final endpoints and DTOs
@Service
class MovementService(
    private val movementRepository: MovementRepository,
) {
    fun getAll(): List<Movement> = movementRepository.findAll()

    fun get(id: Long): Movement =
        movementRepository.findById(id).orElseThrow {
            ResponseStatusException(HttpStatus.NOT_FOUND, "Movement not found")
        }

    fun create(movement: Movement): Movement = movementRepository.save(movement)
}
