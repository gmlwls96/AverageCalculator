package com.hj.average.core.data.di

import com.hj.average.core.data.repository.ItemRepository
import com.hj.average.core.data.repository.ItemRepositoryImpl
import com.hj.average.core.db.dao.ItemDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideItemRepository(
        itemDao: ItemDao
    ): ItemRepository = ItemRepositoryImpl(itemDao)
}