package com.hj.average.core.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.hj.average.core.db.entity.ItemEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao : BaseDao<ItemEntity> {

    @Query("SELECT * FROM itementity WHERE id = :id")
    fun getItemEntityOrNull(id: Int): Flow<ItemEntity?>

    @Query("SELECT * FROM itementity ORDER BY date")
    fun getItemList(): Flow<List<ItemEntity>>
}