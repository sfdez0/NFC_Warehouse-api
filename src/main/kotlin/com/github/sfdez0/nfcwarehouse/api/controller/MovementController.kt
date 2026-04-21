package com.github.sfdez0.nfcwarehouse.api.controller

import com.github.sfdez0.nfcwarehouse.api.model.Movement
import com.github.sfdez0.nfcwarehouse.api.service.MovementService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * TODO
 */
@RestController
@RequestMapping("/api/v1/movements")
class MovementController(
    private val movementService: MovementService,
) {
    @GetMapping("/{id}")
    fun getMovementById(
        @PathVariable id: Long,
    ): Movement? = movementService.findById(id)
}
