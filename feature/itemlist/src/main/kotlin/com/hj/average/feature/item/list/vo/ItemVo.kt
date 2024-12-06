package com.hj.average.feature.item.list.vo

import com.hj.average.core.models.ItemModel

data class ItemVo(
    val id: Int,
    val title: String,
    val date: String,
    val averagePrice: Double,
    val profit: Double,
    val totalPurchasePrice: Double
) {
    companion object {
        fun ItemModel.toVo() = ItemVo(
            id = id,
            title = name,
            date = "$date",
            averagePrice = averagePrice,
            profit = profit,
            totalPurchasePrice = totalPurchasePrice
        )
    }
}