package com.hj.average.feature.item.detail.state

data class DetailUiState(
    val title: String = "",
    val firstPrice: String = "",
    val firstQuantity: String = "",
    val secondPrice: String = "",
    val secondQuantity: String = "",
    val totalQuantity: String = "",
    val totalAveragePrice: String = "",
    val totalProfit: String = "",
    val totalPrice: String = ""
)