package com.github.sfdez0.nfcwarehouse.api.repository

import com.github.sfdez0.nfcwarehouse.api.model.Item
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ItemRepository : JpaRepository<Item, Long>
