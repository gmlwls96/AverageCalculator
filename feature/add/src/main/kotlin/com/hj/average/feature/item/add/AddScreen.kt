package com.hj.average.feature.item.add

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.hj.average.feature.common.input.TotalInputInfo
import com.hj.average.feature.common.input.priceInputScreen
import com.hj.average.feature.item.add.components.AddHeader
import com.hj.average.feature.item.add.components.BottomBtn
import com.hj.average.feature.item.add.event.AddEvent
import com.hj.average.feature.item.add.state.AddUiState
import com.hj.average.ui.component.core.SpacerHeight
import com.hj.average.ui.theme.AppTheme
import com.hj.average.ui.theme.AveTheme

@Composable
internal fun AddScreen() {
    val uiState by remember {
        mutableStateOf(AddUiState())
    }

    AddContents(
        uiState = uiState,
        onEvent = {}
    )
}

@Composable
private fun AddContents(
    modifier: Modifier = Modifier,
    uiState: AddUiState,
    onEvent: (AddEvent) -> Unit
) {
    Scaffold(
        modifier = modifier,
        topBar = { AddHeader(onBack = { AddEvent.ClickBack }) },
        bottomBar = {
            BottomBtn(
                isEnable = uiState.isSaveBtnEnable,
                onClick = { onEvent(AddEvent.ClickSave) }
            )
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(it)
                .padding(horizontal = AppTheme.dimensions.padding20)
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