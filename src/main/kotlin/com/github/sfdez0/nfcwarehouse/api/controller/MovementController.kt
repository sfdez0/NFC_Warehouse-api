package com.github.sfdez0.nfcwarehouse.api.controller

import com.github.sfdez0.nfcwarehouse.api.dto.MovementCreateDTO
import com.github.sfdez0.nfcwarehouse.api.dto.MovementResponseDTO
import com.github.sfdez0.nfcwarehouse.api.service.MovementService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

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
    fun getAllMovements(): ResponseEntity<List<MovementResponseDTO>> = ResponseEntity.ok(movementService.getAll())

    /**
     * GET /api/v1/movements/{id}
     */
    @GetMapping("/{id}")
    fun getMovementById(
        @PathVariable id: Long,
    ): ResponseEntity<MovementResponseDTO> {
        val movement = movementService.get(id)

        return if (movement != null) {
            ResponseEntity.ok(movement) // 200 OK
        } else {
            ResponseEntity.notFound().build() // 404 Not Found
        }
    }

    /**
     * POST /api/v1/movements
     */
    @PostMapping
    fun createMovement(
        @RequestBody movement: MovementCreateDTO,
    ): ResponseEntity<MovementResponseDTO> {
        val newMovement = movementService.create(movement)

        val uri =
            ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newMovement.id)
                .toUri()

        return ResponseEntity.created(uri).body(newMovement) // 201 Created
    }
}
