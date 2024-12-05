package com.hj.average.core.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hj.average.core.db.dao.ItemDao
import com.hj.average.core.db.entity.ItemEntity

@Database(
    entities = [
        ItemEntity::class
    ],
    version = 1,
    exportSchema = false
)
// @TypeConverters()
abstract class AveDataBase : RoomDatabase() {
    companion object {
        @Volatile
        private var INSTANCE: AveDataBase? = null
        private const val DB_NAME = "Ave"

        fun getInstance(context: Context): AveDataBase = INSTANCE ?: synchronized(this) {
            INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
        }

        private fun buildDatabase(context: Context): AveDataBase = Room.databaseBuilder(
            context,
            AveDataBase::class.java,
            DB_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    abstract fun itemDao(): ItemDao
}