package com.hj.average.core.models

data class ItemModel(
    val id: Int,
    val name: String,
    val date: Long,
    val firstPrice: Double,
    val firstQuantity: Double,
    val secondPrice: Double,
    val secondQuantity: Double
) {
    val firstValuePrice = firstPrice * firstQuantity
    val secondValuePrice = secondPrice * secondQuantity
    val totalPrice = firstValuePrice + secondValuePrice
    val totalQuantity = firstQuantity + secondQuantity
    val totalPurchasePrice: Double = firstValuePrice + secondValuePrice
    val currentPriceValue = secondPrice * totalQuantity
    val averagePrice: Double = totalPrice / totalQuantity
    val profit: Double = ((currentPriceValue - totalPrice) / totalPrice) * 100.0
}