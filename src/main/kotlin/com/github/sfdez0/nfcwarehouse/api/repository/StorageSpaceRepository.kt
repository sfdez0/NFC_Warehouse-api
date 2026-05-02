package com.github.sfdez0.nfcwarehouse.api.repository

import com.github.sfdez0.nfcwarehouse.api.model.StorageSpace
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface StorageSpaceRepository : JpaRepository<StorageSpace, Long> {
    @EntityGraph(attributePaths = ["items.movements"])
    override fun findAll(): List<StorageSpace>

    @EntityGraph(attributePaths = ["items.movements"])
    override fun findById(id: Long): Optional<StorageSpace>
}
