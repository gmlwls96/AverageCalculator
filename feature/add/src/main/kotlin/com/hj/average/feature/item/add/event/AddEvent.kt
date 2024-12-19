package com.hj.average.feature.item.add.event

sealed class AddEvent {
    data object ClickBack : AddEvent()
    data object ClickSave : AddEvent()
    data class InputTitle(val text: String) : AddEvent()
    data class InputFirstPrice(val text: String) : AddEvent()
    data class InputFirstQuantity(val text: String) : AddEvent()
    data class InputSecondPrice(val text: String) : AddEvent()
    data class InputSecondQuantity(val text: String) : AddEvent()
}