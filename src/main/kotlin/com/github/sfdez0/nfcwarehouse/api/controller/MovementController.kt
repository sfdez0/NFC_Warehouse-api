package com.github.sfdez0.nfcwarehouse.api.controller

import com.github.sfdez0.nfcwarehouse.api.model.Movement
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

/**
 * TODO
 */
@RestController
class MovementController {
    @GetMapping("/movements/{id}")
    fun getMovement(@PathVariable id: String) : Movement? {
        return null
    }
}