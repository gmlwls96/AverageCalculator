package com.hj.average.core.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.hj.average.core.db.entity.ItemEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao : BaseDao<ItemEntity> {

    @Query("SELECT * FROM itementity WHERE id=:id LIMIT 1")
    fun getItemEntity(id: Int): Flow<ItemEntity>

    @Query("SELECT * FROM itementity ORDER BY date")
    fun getItemList(): Flow<List<ItemEntity>>

    @Query("DELETE FROM itementity WHERE id=:id")
    fun deleteItem(id: Int)
}