package com.github.sfdez0.nfcwarehouse.api.repository

import com.github.sfdez0.nfcwarehouse.api.model.Item
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface ItemRepository : JpaRepository<Item, Long> {
    @EntityGraph(attributePaths = ["movements"])
    override fun findAll(): List<Item>

    @EntityGraph(attributePaths = ["movements"])
    override fun findById(id: Long): Optional<Item>
}
