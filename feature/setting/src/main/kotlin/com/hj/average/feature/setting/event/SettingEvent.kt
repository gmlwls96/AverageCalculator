package com.hj.average.feature.setting.event

sealed class SettingEvent {
    data class ClickMenu(val stringRes: Int) : SettingEvent()
}