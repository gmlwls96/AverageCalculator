package com.hj.average.core.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.hj.average.core.data.api.TestApiService
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiServiceModule {

    @Provides
    @Singleton
    fun provideTestApiService(
        retrofit: Retrofit,
    ): TestApiService = retrofit.create(TestApiService::class.java)
}