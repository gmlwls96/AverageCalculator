package com.hj.average.feature.main.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import hw.dp.core.ui.navigator.api.NavigatorApi
import hw.dp.core.ui.navigator.api.NavigatorImpl

@Module
@InstallIn(ActivityComponent::class)
object MainModule {
    @Provides
    fun provideNavigator(): NavigatorApi = NavigatorImpl()
}