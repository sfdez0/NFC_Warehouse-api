package com.github.sfdez0.nfcwarehouse.api.model

import com.fasterxml.jackson.annotation.JsonManagedReference
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
 * Class that represents a Storage Space inside a Location
 */
@Entity
@Table(name = "storage_spaces")
class StorageSpace(
    /**
     * Storage Space ID
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
     * Storage Space name
     */
    @Column(nullable = false)
    var name: String,
    /**
     * Storage Space N:1 Location
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    var location: Location,
    /**
     * StorageSpace 1:N Item
     */
    @OneToMany(mappedBy = "storageSpace", cascade = [CascadeType.ALL])
    @JsonManagedReference
    val items: MutableSet<Item> = mutableSetOf(),
)
