package com.hj.average.feature.item.detail

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
import com.hj.average.feature.item.detail.components.BottomBtn
import com.hj.average.feature.item.detail.components.DetailHeader
import com.hj.average.feature.item.detail.event.DetailEvent
import com.hj.average.feature.item.detail.state.DetailUiState
import com.hj.average.ui.component.core.SpacerHeight
import com.hj.average.ui.component.core.addFocusCleaner
import com.hj.average.ui.theme.AppTheme
import com.hj.average.ui.theme.AveTheme

@Composable
fun DetailScreen(
    vm: DetailViewModel = hiltViewModel()
) {
    val uiState by vm.uiState.collectAsStateWithLifecycle()

    DetailContents(
        uiState = uiState,
        onEvent = vm::onEvent
    )
}

@Composable
internal fun DetailContents(
    focusManager: FocusManager = LocalFocusManager.current,
    uiState: DetailUiState,
    onEvent: (DetailEvent) -> Unit,
) {
    Scaffold(
        topBar = {
            DetailHeader(
                title = uiState.title,
                onEvent = onEvent
            )
        },
        bottomBar = {
            BottomBtn(
                isEnable = uiState.isSaveBtnEnable,
                onClick = { onEvent(DetailEvent.ClickModify) }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .padding(AppTheme.dimensions.padding20)
                .addFocusCleaner(focusManager)
        ) {
            priceInputScreen(
                title = uiState.title,
                onTitleChange = { onEvent(DetailEvent.InputTitle(it)) },
                firstPrice = uiState.firstPrice,
                onFirstPriceChange = { onEvent(DetailEvent.InputFirstPrice(it)) },
                firstQuantity = uiState.firstQuantity,
                onFirstQuantityChange = { onEvent(DetailEvent.InputFirstQuantity(it)) },
                secondPrice = uiState.secondPrice,
                onSecondPriceChange = { onEvent(DetailEvent.InputSecondPrice(it)) },
                secondQuantity = uiState.secondQuantity,
                onSecondQuantityChange = { onEvent(DetailEvent.InputSecondQuantity(it)) }
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

@Preview(showBackground = true)
@Composable
fun DetailContentsPreview() {
    AveTheme(isDarkTheme = false) {
        DetailContents(
            uiState = DetailUiState(
                title = "삼성전자",
                firstPrice = "56300",
                firstQuantity = "10",
                secondPrice = "59000",
                secondQuantity = "20",
                totalQuantity = "30",
                totalAveragePrice = "58000",
                totalProfit = "10.3%",
                totalPrice = "10934903"
            ),
            onEvent = {}
        )
    }
}