package com.hj.average.feature.item.add.state

data class AddUiState(
    val title: String = "",
    val firstPrice: String = "",
    val firstQuantity: String = "",
    val secondPrice: String = "",
    val secondQuantity: String = "",
    val totalQuantity: String = "",
    val totalAveragePrice: String = "",
    val totalProfit: String = "",
    val totalPrice: String = "",
    val isSaveBtnEnable: Boolean = false
)
