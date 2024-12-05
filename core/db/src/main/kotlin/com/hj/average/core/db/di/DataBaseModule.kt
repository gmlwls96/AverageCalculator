package com.hj.average.core.db.di

import android.content.Context
import com.hj.average.core.db.AveDataBase
import com.hj.average.core.db.dao.ItemDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {
    @Singleton
    @Provides
    fun provideTowDataBase(@ApplicationContext context: Context): AveDataBase =
        AveDataBase.getInstance(context)

    @Singleton
    @Provides
    fun provideItemDao(aveDataBase: AveDataBase): ItemDao = aveDataBase.itemDao()
}