package com.hj.average.feature.item.list.event

import com.hj.average.feature.item.list.vo.ItemVo

internal sealed class ListEvent {
    data class ClickItem(val itemVo: ItemVo) : ListEvent()

    data object ClickAdd : ListEvent()
}