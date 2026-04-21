package com.github.sfdez0.nfcwarehouse.api.controller

import com.github.sfdez0.nfcwarehouse.api.model.Movement
import com.github.sfdez0.nfcwarehouse.api.service.MovementService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

/**
 * Movements Endpoints
 */
@RestController
@RequestMapping("/api/v1/movements")
class MovementController(
    private val movementService: MovementService,
) {
    /**
     * GET /api/v1/movements
     */
    @GetMapping
    fun getAllMovements(): List<Movement> = movementService.getAll()

    /**
     * GET /api/v1/movements/{id}
     */
    @GetMapping("/{id}")
    fun getMovementById(
        @PathVariable id: Long,
    ): Movement? = movementService.get(id)

    /**
     * POST /api/v1/movements
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createMovement(
        @RequestBody movement: Movement,
    ): Movement = movementService.create(movement)
}
