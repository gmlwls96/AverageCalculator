package com.hj.average.core.data.repository

import com.hj.average.core.db.dao.ItemDao
import com.hj.average.core.data.mapper.toEntity
import com.hj.average.core.data.mapper.toModel
import com.hj.average.core.models.ItemModel
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

    override fun getItemOrNull(id: Int): Flow<ItemModel?> = itemDao.getItemEntityOrNull(id = id)
        .map { it?.toModel() }
        .catch {
            it.printStackTrace()
            emit(null)
        }

    override suspend fun updateItem(itemModel: ItemModel) {
        itemDao.update(itemModel.toEntity())
    }
}