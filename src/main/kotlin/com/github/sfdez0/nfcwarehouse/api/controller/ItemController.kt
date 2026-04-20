package com.github.sfdez0.nfcwarehouse.api.controller

import com.github.sfdez0.nfcwarehouse.api.model.Item
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

/**
 * TODO
 */
@RestController
class ItemController {
    @GetMapping("/items/{id}")
    fun getItem(@PathVariable id: String) : Item? {
        return null
    }
}