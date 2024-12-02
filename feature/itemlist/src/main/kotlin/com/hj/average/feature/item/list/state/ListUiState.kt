package com.hj.average.feature.item.list.state

import com.hj.average.feature.item.list.vo.ItemVo
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

internal data class ListUiState(
    val itemList: ImmutableList<ItemVo> = persistentListOf()
)