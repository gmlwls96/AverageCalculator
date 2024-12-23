package com.hj.average.feature.setting

import androidx.lifecycle.ViewModel
import com.hj.average.feature.setting.event.SettingEvent
import com.hj.average.feature.setting.state.SettingUiState
import com.hj.tw.feature.common.state.StateReducerFlow
import com.hj.tw.feature.common.state.StateReducerFlowImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import com.hj.average.core.res.R
import com.hj.average.ui.route.BugReportRoute
import com.hj.average.ui.route.SettingThemeRoute
import hw.dp.core.ui.navigator.api.NavigatorApi
import javax.inject.Inject

@HiltViewModel
class SettingViewModel @Inject constructor(
    private val navigatorApi: NavigatorApi,
) : ViewModel() {
    val uiState: StateReducerFlow<SettingUiState> = StateReducerFlowImpl(SettingUiState())

    fun onEvent(event: SettingEvent) {
        when (event) {
            is SettingEvent.ClickMenu -> clickMenu(event.stringRes)
        }
    }

    private fun clickMenu(res: Int) {
        when (res) {
            R.string.setting_theme -> {
                navigatorApi.navigate(SettingThemeRoute())
            }

            R.string.setting_bug -> {
                navigatorApi.navigate(BugReportRoute())
            }

            else -> {}
        }
    }
}