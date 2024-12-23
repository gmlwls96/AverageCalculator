package com.hj.tw.feature.common.state

import kotlinx.coroutines.flow.StateFlow

interface StateReducerFlow<STATE> : StateFlow<STATE> {
    fun reduce(transform: STATE.() -> STATE) {}
}