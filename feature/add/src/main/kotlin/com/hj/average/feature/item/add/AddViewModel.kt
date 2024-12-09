package com.hj.average.feature.item.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hj.average.core.data.repository.ItemRepository
import com.hj.average.core.models.ItemModel
import com.hj.average.feature.item.add.event.AddEvent
import com.hj.average.feature.item.add.state.AddUiState
import com.hj.tw.feature.common.state.StateReducerFlow
import com.hj.tw.feature.common.state.StateReducerFlowImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import hw.dp.core.ui.navigator.api.NavigatorApi
import java.math.BigDecimal
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class AddViewModel @Inject constructor(
    private val itemRepository: ItemRepository,
    private val navigatorApi: NavigatorApi,
) : ViewModel() {

    val uiState: StateReducerFlow<AddUiState> = StateReducerFlowImpl(AddUiState())

    fun onEvent(event: AddEvent) {
        when (event) {
            is AddEvent.ClickBack -> clickBack()
            is AddEvent.ClickSave -> clickSave()
            is AddEvent.InputTitle -> inputTitle(event.text)
            is AddEvent.InputFirstPrice -> inputFirstPrice(event.text)
            is AddEvent.InputFirstQuantity -> inputFirstQuantity(event.text)
            is AddEvent.InputSecondPrice -> inputSecondPrice(event.text)
            is AddEvent.InputSecondQuantity -> inputSecondQuantity(event.text)
        }
    }

    private fun clickBack() {
        navigatorApi.popBackStack()
    }

    private fun clickSave() = viewModelScope.launch {
        with(uiState.value) {
            itemRepository.addItem(
                name = title,
                firstPrice = firstPrice,
                firstQuantity = firstQuantity,
                secondPrice = secondPrice,
                secondQuantity = secondQuantity
            )
        }
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

    private fun checkSaveBtnEnable(state: AddUiState) {
        // todo : 추후 다른 방법 알아보기.
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
}