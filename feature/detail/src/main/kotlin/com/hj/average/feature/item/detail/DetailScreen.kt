package com.hj.average.feature.item.detail

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import com.hj.average.feature.common.input.TotalInputInfo
import com.hj.average.feature.common.input.priceInputScreen
import com.hj.average.feature.item.detail.components.DetailHeader
import com.hj.average.feature.item.detail.event.DetailEvent
import com.hj.average.feature.item.detail.state.DetailUiState
import com.hj.average.ui.component.core.SpacerHeight
import com.hj.average.ui.component.core.addFocusCleaner
import com.hj.average.ui.theme.AppTheme
import com.hj.average.ui.theme.AveTheme

@Composable
fun DetailScreen() {
    val uiState by remember {
        mutableStateOf(DetailUiState())
    }
    DetailContents(
        uiState = uiState,
        onEvent = {}
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
                onTitleChange = {},
                firstPrice = uiState.firstPrice,
                onFirstPriceChange = {},
                firstQuantity = uiState.firstQuantity,
                onFirstQuantityChange = {},
                secondPrice = uiState.secondPrice,
                onSecondPriceChange = {},
                secondQuantity = uiState.secondQuantity,
                onSecondQuantityChange = {}
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