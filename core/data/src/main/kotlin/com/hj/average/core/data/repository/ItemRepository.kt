package com.hj.average.core.data.repository

import com.hj.average.core.models.ItemModel
import kotlinx.coroutines.flow.Flow

interface ItemRepository {
    fun getItemList(): Flow<List<ItemModel>>
    fun getItemOrNull(id: Int): Flow<ItemModel?>
    suspend fun updateItem(itemModel: ItemModel)
    suspend fun addItem(
        name: String,
        firstPrice: String,
        firstQuantity: String,
        secondPrice: String,
        secondQuantity: String
    )
}