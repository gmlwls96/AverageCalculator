package com.hj.average.feature.setting.state

import com.hj.average.core.res.R
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

data class SettingUiState(
    val settingList: ImmutableList<Int> = persistentListOf(
        R.string.setting_theme,
        R.string.setting_bug
    )
)