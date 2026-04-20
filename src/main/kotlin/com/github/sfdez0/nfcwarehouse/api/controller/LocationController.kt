package com.github.sfdez0.nfcwarehouse.api.controller

import com.github.sfdez0.nfcwarehouse.api.model.Location
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

/**
 * TODO
 */
@RestController
class LocationController {
    @GetMapping("/locations/{id}")
    fun getLocation(@PathVariable id: String) : Location? {
        return null
    }
}