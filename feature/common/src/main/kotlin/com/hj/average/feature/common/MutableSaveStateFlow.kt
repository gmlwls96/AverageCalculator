package com.hj.average.feature.common

import androidx.lifecycle.SavedStateHandle
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MutableSaveStateFlow<T>(
    private val savedStateHandle: SavedStateHandle,
    private val key: String,
    defaultValue: T,
) {
    private val _state: MutableStateFlow<T> =
        MutableStateFlow(savedStateHandle.get<T>(key) ?: defaultValue)

    var value: T
        get() = _state.value
        set(value) {
            _state.value = value
            savedStateHandle[key] = value
        }

    fun asStateFlow(): StateFlow<T> = _state.asStateFlow()

    fun update(function: (T) -> T) {
        _state.update(function = function)
    }
}
