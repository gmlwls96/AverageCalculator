package com.hj.average.feature.item.add.event

sealed class AddEvent {
    data object ClickBack : AddEvent()
    data object ClickSave : AddEvent()
}