package com.github.sfdez0.nfcwarehouse.api.service

import com.github.sfdez0.nfcwarehouse.api.model.Movement
import com.github.sfdez0.nfcwarehouse.api.repository.MovementRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class MovementService(
    private val movementRepository: MovementRepository,
) {
    fun findById(id: Long): Movement =
        movementRepository.findById(id).orElseThrow {
            ResponseStatusException(HttpStatus.NOT_FOUND, "Location not found")
        }

    fun save(movement: Movement): Movement = movementRepository.save(movement)
}
