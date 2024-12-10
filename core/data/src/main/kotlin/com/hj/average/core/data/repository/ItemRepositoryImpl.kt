package com.hj.average.core.data.repository

import com.hj.average.core.db.dao.ItemDao
import com.hj.average.core.data.mapper.toEntity
import com.hj.average.core.data.mapper.toModel
import com.hj.average.core.db.entity.ItemEntity
import com.hj.average.core.models.ItemModel
import java.math.BigDecimal
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class ItemRepositoryImpl(
    private val itemDao: ItemDao,
) : ItemRepository {
    override fun getItemList(): Flow<List<ItemModel>> = flow {
        itemDao.getItemList()
            .map { list ->
                list.map {
                    it.toModel()
                }
            }
            .collect {
                emit(it)
            }
    }
        .catch {
            it.printStackTrace()
            emit(emptyList())
        }

    override fun getItem(id: Int): Flow<ItemModel> =
        itemDao.getItemEntity(id = id)
            .map { it.toModel() }
            .catch {
                it.printStackTrace()
                emit(ItemModel.EMPTY)
            }

    override suspend fun updateItem(itemModel: ItemModel) {
        itemDao.update(itemModel.toEntity())
    }

    override suspend fun addItem(
        name: String,
        firstPrice: String,
        firstQuantity: String,
        secondPrice: String,
        secondQuantity: String
    ) {
        itemDao.insert(
            ItemEntity(
                name = name,
                date = System.currentTimeMillis(),
                firstPrice = BigDecimal(firstPrice),
                firstQuantity = BigDecimal(firstQuantity),
                secondPrice = BigDecimal(secondPrice),
                secondQuantity = BigDecimal(secondQuantity)
            )
        )
    }
}