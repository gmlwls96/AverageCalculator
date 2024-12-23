package com.hj.average.feature.item.detail.event

sealed class DetailEvent {
    data object ClickBack : DetailEvent()
    data object ClickAdd : DetailEvent()
    data object ClickModify : DetailEvent()
    data class InputTitle(val text: String) : DetailEvent()
    data class InputFirstPrice(val text: String) : DetailEvent()
    data class InputFirstQuantity(val text: String) : DetailEvent()
    data class InputSecondPrice(val text: String) : DetailEvent()
    data class InputSecondQuantity(val text: String) : DetailEvent()
}