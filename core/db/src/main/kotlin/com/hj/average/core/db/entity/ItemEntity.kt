package com.hj.average.core.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.math.BigDecimal

@Entity
data class ItemEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val date: Long,
    val firstPrice: BigDecimal,
    val firstQuantity: BigDecimal,
    val secondPrice: BigDecimal,
    val secondQuantity: BigDecimal
)
