package com.hj.average.feature.item.detail.event

sealed class DetailEvent {
    data object ClickBack : DetailEvent()
    data object ClickAdd : DetailEvent()
}