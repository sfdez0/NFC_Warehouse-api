package com.github.sfdez0.nfcwarehouse.api.model

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.Table

/**
 * Class that represents an Item
 */
@Entity
@Table(name = "items")
class Item(
    /**
     * Item ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    /**
     * NFC Tag ID
     */
    @Column(unique = true, nullable = false)
    val nfcTagId: String,
    /**
     * Item name
     */
    @Column(nullable = false)
    var name: String,
    /**
     * Item quantity
     */
    var quantity: Int = 0,
    /**
     * Item N:1 Storage Space
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "storage_space_id")
    val storageSpace: StorageSpace,
    /**
     * Item 1:N Movement
     */
    @OneToMany(mappedBy = "item", cascade = [CascadeType.ALL])
    val movements: MutableList<Movement> = mutableListOf(),
)
