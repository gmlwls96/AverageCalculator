package com.hj.average.feature.item.detail.state

import com.hj.average.core.models.ItemModel

data class DetailUiState(
    val title: String = "",
    val firstPrice: String = "",
    val firstQuantity: String = "",
    val secondPrice: String = "",
    val secondQuantity: String = "",
    val totalQuantity: String = "",
    val totalAveragePrice: String = "",
    val totalProfit: String = "",
    val totalPrice: String = "",
    val isSaveBtnEnable: Boolean = false,
) {
    companion object {
        fun ItemModel.toState() = DetailUiState(
            title = name,
            firstPrice = firstPrice.toString(),
            firstQuantity = firstQuantity.toString(),
            secondPrice = secondPrice.toString(),
            secondQuantity = secondQuantity.toString(),
            totalQuantity = totalQuantity.toString(),
            totalAveragePrice = averagePrice.toString(),
            totalProfit = profit.toString(),
            totalPrice = totalPrice.toString(),
            isSaveBtnEnable = false
        )
    }
}