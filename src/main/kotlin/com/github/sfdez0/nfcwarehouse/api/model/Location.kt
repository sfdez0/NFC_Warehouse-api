package com.github.sfdez0.nfcwarehouse.api.model

import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table

/**
 * Class that represents a Location
 */
@Entity
@Table(name = "locations")
class Location(
    /**
     * Location ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    /**
     * Location name
     */
    @Column
    var name: String,
    /**
     * Location description
     */
    var description: String? = null,
    /**
     * Location 1:N Storage Space
     */
    @OneToMany(mappedBy = "location", cascade = [(CascadeType.ALL)])
    @JsonManagedReference
    val storageSpaces: MutableSet<StorageSpace> = mutableSetOf(),
)
