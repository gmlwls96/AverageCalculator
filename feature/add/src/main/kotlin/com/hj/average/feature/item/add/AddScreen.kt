package com.hj.average.feature.item.add

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.hj.average.feature.common.input.TotalInputInfo
import com.hj.average.feature.common.input.priceInputScreen
import com.hj.average.feature.item.add.components.AddHeader
import com.hj.average.feature.item.add.components.BottomBtn
import com.hj.average.feature.item.add.event.AddEvent
import com.hj.average.feature.item.add.state.AddUiState
import com.hj.average.ui.component.core.SpacerHeight
import com.hj.average.ui.component.core.addFocusCleaner
import com.hj.average.ui.theme.AppTheme
import com.hj.average.ui.theme.AveTheme

@Composable
internal fun AddScreen(
    vm: AddViewModel = hiltViewModel()
) {
    val uiState by vm.uiState.collectAsStateWithLifecycle()

    AddContents(
        uiState = uiState,
        onEvent = vm::onEvent
    )
}

@Composable
private fun AddContents(
    modifier: Modifier = Modifier,
    focusManager: FocusManager = LocalFocusManager.current,
    uiState: AddUiState,
    onEvent: (AddEvent) -> Unit
) {
    Scaffold(
        modifier = modifier.addFocusCleaner(focusManager),
        topBar = { AddHeader(onBack = { AddEvent.ClickBack }) },
        bottomBar = {
            BottomBtn(
                isEnable = uiState.isSaveBtnEnable,
                onClick = { onEvent(AddEvent.ClickSave) }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = AppTheme.dimensions.padding20)
        ) {
            priceInputScreen(
                title = uiState.title,
                onTitleChange = { onEvent(AddEvent.InputTitle(it)) },
                firstPrice = uiState.firstPrice,
                onFirstPriceChange = { onEvent(AddEvent.InputFirstPrice(it)) },
                firstQuantity = uiState.firstQuantity,
                onFirstQuantityChange = { onEvent(AddEvent.InputFirstQuantity(it)) },
                secondPrice = uiState.secondPrice,
                onSecondPriceChange = { onEvent(AddEvent.InputSecondPrice(it)) },
                secondQuantity = uiState.secondQuantity,
                onSecondQuantityChange = { onEvent(AddEvent.InputSecondQuantity(it)) }
            )

            item {
                SpacerHeight(dp = AppTheme.dimensions.padding30)
                TotalInputInfo(
                    totalQuantity = uiState.totalQuantity,
                    totalAveragePrice = uiState.totalAveragePrice,
                    totalProfit = uiState.totalProfit,
                    totalPrice = uiState.totalPrice
                )
            }
        }
    }
}

@Preview
@Composable
private fun AddContentsPreview() {
    AveTheme(isDarkTheme = false) {
        AddContents(
            uiState = AddUiState(
                title = "삼성전자",
                firstPrice = "56300",
                firstQuantity = "10",
                secondPrice = "59000",
                secondQuantity = "20",
                totalQuantity = "30",
                totalAveragePrice = "58000",
                totalProfit = "10.3%",
                totalPrice = "10934903",
                isSaveBtnEnable = true
            ),
            onEvent = {}
        )
    }
}