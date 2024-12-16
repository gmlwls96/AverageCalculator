package com.hj.average.feature.item.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hj.average.core.data.repository.ItemRepository
import com.hj.average.feature.item.list.event.ListEvent
import com.hj.average.feature.item.list.state.ListUiState
import com.hj.average.feature.item.list.vo.ItemVo
import com.hj.average.feature.item.list.vo.ItemVo.Companion.toVo
import com.hj.average.ui.route.AddRoute
import com.hj.average.ui.route.DetailRoute
import com.hj.tw.feature.common.state.StateReducerFlow
import com.hj.tw.feature.common.state.StateReducerFlowImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import hw.dp.core.ui.navigator.api.NavigatorApi
import javax.inject.Inject
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

@HiltViewModel
class ItemListViewModel @Inject constructor(
    private val itemRepository: ItemRepository,
    private val navigatorApi: NavigatorApi
) : ViewModel() {

    val uiState: StateReducerFlow<ListUiState> = StateReducerFlowImpl(ListUiState())

    private val itemListFlow = itemRepository.getItemList()
        .map { list ->
            list.map { it.toVo() }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    init {
        viewModelScope.launch {
            itemListFlow.collect {
                uiState.reduce { copy(itemList = it.toImmutableList()) }
            }
        }
    }

    fun onEvent(event: ListEvent) {
        when (event) {
            is ListEvent.ClickItem -> clickItem(event.itemVo)
            is ListEvent.DeleteItem -> deleteItem(event.itemVo)
            is ListEvent.ClickAdd -> clickAdd()
        }
    }

    private fun clickItem(itemVo: ItemVo) {
        navigatorApi.navigate(DetailRoute(itemId = itemVo.id))
    }

    private fun deleteItem(itemVo: ItemVo) = viewModelScope.launch(Dispatchers.IO) {
        itemRepository.deleteItem(itemVo.id)
    }

    private fun clickAdd() {
        navigatorApi.navigate(AddRoute())
    }
}