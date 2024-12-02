package com.hj.average.feature.item.list.vo

internal data class ItemVo(
    val id: Int,
    val title: String,
    val date: String,
    val averagePrice: Double,
    val profit: Double,
    val totalPurchasePrice: Double
)