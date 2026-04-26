package com.github.sfdez0.nfcwarehouse.api.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.Instant

/**
 * Class that represents an item Movement
 */
@Entity
@Table(name = "movements")
class Movement(
    /**
     * Movement ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    /**
     * Movement N:1 Item
     */
    @ManyToOne
    @JoinColumn(name = "item_id")
    val item: Item,
    /**
     * Movement N:1 Storage Space
     */
    @ManyToOne
    @JoinColumn(name = "storage_space_id")
    val storageSpace: StorageSpace,
    /**
     * Quantity moved
     */
    val quantityChanged: Int,
    /**
     * Movement timestamp
     */
    val timestamp: Instant = Instant.now(),
    /**
     * Movement description
     */
    val description: String? = null,
)
