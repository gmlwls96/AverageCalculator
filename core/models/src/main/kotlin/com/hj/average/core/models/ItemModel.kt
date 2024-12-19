package com.hj.average.core.models

import java.math.BigDecimal
import java.math.RoundingMode

data class ItemModel(
    val id: Int,
    val name: String,
    val date: Long,
    val firstPrice: BigDecimal,
    val firstQuantity: BigDecimal,
    val secondPrice: BigDecimal,
    val secondQuantity: BigDecimal
) {
    val firstValuePrice = firstPrice.multiply(firstQuantity)
    val secondValuePrice = secondPrice.multiply(secondQuantity)
    val totalPrice = firstValuePrice.add(secondValuePrice)
    val totalQuantity = firstQuantity.add(secondQuantity)
    val totalPurchasePrice: BigDecimal = firstValuePrice.add(secondValuePrice)
    val currentPriceValue = secondPrice.multiply(totalQuantity)
    val averagePrice: BigDecimal = try {
        totalPrice.divide(totalQuantity, 10, RoundingMode.HALF_UP)
    } catch (e: ArithmeticException) {
        BigDecimal(0)
    }
    val profit: BigDecimal = try {
        (currentPriceValue.subtract(totalPrice)).divide(totalPrice, 10, RoundingMode.HALF_UP)
            .multiply(BigDecimal(100.0))
    } catch (e: ArithmeticException) {
        BigDecimal(0)
    }

    companion object {
        val EMPTY = ItemModel(
            id = 0,
            name = "",
            date = 0,
            firstPrice = BigDecimal("0"),
            firstQuantity = BigDecimal("0"),
            secondPrice = BigDecimal("0"),
            secondQuantity = BigDecimal("0")
        )
    }
}