package com.hj.average.feature.item.list

import androidx.compose.foundation.layout.fillMaxSize
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
import com.hj.average.feature.item.list.components.EmptyScreen
import com.hj.average.feature.item.list.components.ListHeader
import com.hj.average.feature.item.list.components.SwipeToDismissItemRow
import com.hj.average.feature.item.list.event.ListEvent
import com.hj.average.feature.item.list.state.ListUiState
import com.hj.average.feature.item.list.vo.ItemVo
import com.hj.average.ui.theme.AppTheme
import com.hj.average.ui.theme.AveTheme
import kotlinx.collections.immutable.persistentListOf

@Composable
fun ItemListScreen(
    modifier: Modifier = Modifier,
    vm: ItemListViewModel = hiltViewModel(),
) {
    val listUiState by vm.uiState.collectAsStateWithLifecycle()

    ItemListContents(
        modifier = modifier,
        listUiState = listUiState,
        onEvent = vm::onEvent
    )
}

@Composable
internal fun ItemListContents(
    modifier: Modifier = Modifier,
    listUiState: ListUiState,
    onEvent: (ListEvent) -> Unit
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            ListHeader { onEvent(ListEvent.ClickAdd) }
        },
        bottomBar = { AdsBottomBar() }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = AppTheme.dimensions.padding20)
        ) {
            if (listUiState.itemList.isEmpty()) {
                item {
                    EmptyScreen()
                }
            }
            items(
                items = listUiState.itemList,
                key = { it.id }
            ) {
                SwipeToDismissItemRow(
                    itemVo = it,
                    onClick = { onEvent(ListEvent.ClickItem(it)) },
                    onDelete = { onEvent(ListEvent.DeleteItem(it)) }
                )
            }
        }
    }
}

@Preview
@Composable
private fun ItemListContentsPreview() {
    AveTheme(isDarkTheme = true) {
        ItemListContents(
            listUiState = ListUiState(
                itemList = persistentListOf(
                    ItemVo(
                        id = 0,
                        title = "삼성전자",
                        date = "2024-11-25",
                        averagePrice = 54750.00,
                        profit = 10.234,
                        totalPurchasePrice = 2189999.99
                    ),
                    ItemVo(
                        id = 1,
                        title = "마이크로소프트",
                        date = "2024-11-24",
                        averagePrice = 100050.00,
                        profit = -20.134,
                        totalPurchasePrice = 32928239.99143
                    ),
                )
            ),
            onEvent = {}
        )
    }
}