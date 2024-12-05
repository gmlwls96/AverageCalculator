package com.hj.average.core.data.repository

import com.hj.average.core.models.ItemModel
import kotlinx.coroutines.flow.Flow

interface ItemRepository {
    fun getItemList(): Flow<List<ItemModel>>
    fun getItemOrNull(id: Int): Flow<ItemModel?>
    suspend fun updateItem(itemModel: ItemModel)
}