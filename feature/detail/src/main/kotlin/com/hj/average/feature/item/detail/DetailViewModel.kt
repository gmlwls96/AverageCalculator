package com.hj.average.feature.item.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hj.average.core.data.repository.ItemRepository
import com.hj.average.core.models.ItemModel
import com.hj.average.feature.common.MutableSaveStateFlow
import com.hj.average.feature.item.detail.event.DetailEvent
import com.hj.average.feature.item.detail.state.DetailUiState
import com.hj.average.feature.item.detail.state.DetailUiState.Companion.toState
import com.hj.average.ui.route.DetailRoute
import com.hj.tw.feature.common.state.StateReducerFlow
import com.hj.tw.feature.common.state.StateReducerFlowImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import hw.dp.core.ui.navigator.api.NavigatorApi
import hw.dp.route.generated.RouteExtension.Companion.ITEMID_KEY
import java.math.BigDecimal
import javax.inject.Inject
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val itemRepository: ItemRepository,
    private val navigatorApi: NavigatorApi,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    val uiState: StateReducerFlow<DetailUiState> = StateReducerFlowImpl(DetailUiState())

    private val itemKey: MutableSaveStateFlow<Int> = MutableSaveStateFlow(
        savedStateHandle = savedStateHandle,
        key = DetailRoute.ITEMID_KEY,
        defaultValue = 0
    )

    private val itemModel: StateFlow<ItemModel?> by lazy {
        itemRepository
            .getItem(itemKey.value)
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = null
            )
    }

    init {
        viewModelScope.launch {
            itemModel
                .collectLatest { model ->
                    model?.let {
                        uiState.reduce { it.toState() }
                    }
                }
        }
    }

    fun onEvent(event: DetailEvent) {
        when (event) {
            is DetailEvent.ClickAdd -> clickAdd()
            is DetailEvent.ClickBack -> clickBack()
            is DetailEvent.ClickModify -> clickModify()
            is DetailEvent.InputTitle -> inputTitle(event.text)
            is DetailEvent.InputFirstPrice -> inputFirstPrice(event.text)
            is DetailEvent.InputFirstQuantity -> inputFirstQuantity(event.text)
            is DetailEvent.InputSecondPrice -> inputSecondPrice(event.text)
            is DetailEvent.InputSecondQuantity -> inputSecondQuantity(event.text)
        }
    }

    private fun clickAdd() {
        itemModel.value?.let { model ->
            val newModel = model.copy(
                firstPrice = model.averagePrice,
                firstQuantity = model.totalQuantity,
                secondPrice = BigDecimal("0"),
                secondQuantity = BigDecimal("0")
            )
            uiState.reduce {
                newModel.toState().copy(
                    secondPrice = "",
                    secondQuantity = ""
                )
            }
        }
    }

    private fun clickBack() {
        navigatorApi.popBackStack()
    }

    private fun inputTitle(text: String) {
        checkSaveBtnEnable(uiState.value.copy(title = text))
    }

    private fun inputFirstPrice(text: String) {
        checkSaveBtnEnable(uiState.value.copy(firstPrice = text))
    }

    private fun inputFirstQuantity(text: String) {
        checkSaveBtnEnable(uiState.value.copy(firstQuantity = text))
    }

    private fun inputSecondPrice(text: String) {
        checkSaveBtnEnable(uiState.value.copy(secondPrice = text))
    }

    private fun inputSecondQuantity(text: String) {
        checkSaveBtnEnable(uiState.value.copy(secondQuantity = text))
    }

    private fun checkSaveBtnEnable(state: DetailUiState) {
        val itemModel = ItemModel(
            id = 0,
            date = 0,
            name = state.title,
            firstPrice = BigDecimal(state.firstPrice.ifEmpty { "0" }),
            firstQuantity = BigDecimal(state.firstQuantity.ifEmpty { "0" }),
            secondPrice = BigDecimal(state.secondPrice.ifEmpty { "0" }),
            secondQuantity = BigDecimal(state.secondQuantity.ifEmpty { "0" }),
        )
        uiState.reduce {
            copy(
                title = state.title,
                firstPrice = state.firstPrice,
                firstQuantity = state.firstQuantity,
                secondPrice = state.secondPrice,
                secondQuantity = state.secondQuantity,
                totalQuantity = itemModel.totalQuantity.toString(),
                totalAveragePrice = itemModel.averagePrice.toString(),
                totalProfit = itemModel.profit.toString(),
                totalPrice = itemModel.totalPrice.toString(),
                isSaveBtnEnable = state.title.isNotEmpty() &&
                    state.firstPrice.isNotEmpty() &&
                    state.firstQuantity.isNotEmpty() &&
                    state.secondPrice.isNotEmpty() &&
                    state.secondQuantity.isNotEmpty()
            )
        }
    }

    private fun clickModify() = viewModelScope.launch {
        itemModel.value?.let { model ->
            itemRepository.updateItem(
                ItemModel(
                    id = model.id,
                    date = model.date,
                    name = uiState.value.title,
                    firstPrice = BigDecimal(uiState.value.firstPrice.ifEmpty { "0" }),
                    firstQuantity = BigDecimal(uiState.value.firstQuantity.ifEmpty { "0" }),
                    secondPrice = BigDecimal(uiState.value.secondPrice.ifEmpty { "0" }),
                    secondQuantity = BigDecimal(uiState.value.secondQuantity.ifEmpty { "0" }),
                )
            )
        }
    }
}