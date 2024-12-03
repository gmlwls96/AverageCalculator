package com.hj.tw.feature.common.state

import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class StateReducerFlowImpl<STATE>(
    initState: STATE,
) : StateReducerFlow<STATE> {

    private val stateFlow = MutableStateFlow(initState)

    override val replayCache: List<STATE> = stateFlow.replayCache
    override val value: STATE
        get() = stateFlow.value

    override suspend fun collect(collector: FlowCollector<STATE>): Nothing {
        stateFlow.collect(collector)
    }

    override fun reduce(transform: STATE.() -> STATE) {
        stateFlow.update { it.transform() }
    }
}