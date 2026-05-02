package com.github.sfdez0.nfcwarehouse.api.repository

import com.github.sfdez0.nfcwarehouse.api.model.Location
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface LocationRepository : JpaRepository<Location, Long> {
    @EntityGraph(attributePaths = ["storageSpaces.items.movements"])
    override fun findAll(): List<Location>

    @EntityGraph(attributePaths = ["storageSpaces.items.movements"])
    override fun findById(id: Long): Optional<Location>
}
