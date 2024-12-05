package com.hj.average.core.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ItemEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val date: Long,
    val firstPrice: Double,
    val firstQuantity: Double,
    val secondPrice: Double,
    val secondQuantity: Double
)