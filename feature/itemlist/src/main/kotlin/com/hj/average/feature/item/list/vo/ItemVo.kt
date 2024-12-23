package com.hj.average.feature.item.list.vo

import com.hj.average.core.models.ItemModel
import com.hj.average.core.utils.DateFormatter

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
            date = DateFormatter.convertTimestampToKoreanDate(date),
            averagePrice = averagePrice.toDouble(),
            profit = profit.toDouble(),
            totalPurchasePrice = totalPurchasePrice.toDouble()
        )
    }
}