package com.hj.average.feature.setting

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.hj.average.feature.common.admob.AdsBottomBar
import com.hj.average.feature.setting.components.SettingHeader
import com.hj.average.feature.setting.components.SettingRow
import com.hj.average.feature.setting.event.SettingEvent
import com.hj.average.ui.theme.AppTheme
import com.hj.average.ui.theme.AveTheme
import com.hj.average.feature.setting.state.SettingUiState

@Composable
internal fun SettingScreen(
    modifier: Modifier = Modifier,
    vm: SettingViewModel = hiltViewModel()
) {
    val uiState by vm.uiState.collectAsStateWithLifecycle()

    SettingContents(
        modifier = modifier,
        uiState = uiState,
        onEvent = vm::onEvent
    )
}

@Composable
internal fun SettingContents(
    modifier: Modifier = Modifier,
    uiState: SettingUiState,
    onEvent: (SettingEvent) -> Unit,
) {
    Scaffold(
        modifier = modifier,
        topBar = { SettingHeader() },
        bottomBar = { AdsBottomBar() }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .padding(horizontal = AppTheme.dimensions.padding20)
        ) {
            items(uiState.settingList) {
                SettingRow(stringRes = it) {
                    onEvent(SettingEvent.ClickMenu(it))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SettingContentsPreview() {
    AveTheme(isDarkTheme = false) {
        SettingContents(
            uiState = SettingUiState(),
            onEvent = {}
        )
    }
}