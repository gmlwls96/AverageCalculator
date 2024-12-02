package com.hj.average.feature.main.di

import com.hj.average.ui.component.bottombar.model.NavigationItem
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import hw.dp.core.ui.navigator.api.NavigatorApi
import hw.dp.core.ui.navigator.api.NavigatorImpl
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import com.hj.average.core.res.R
import com.hj.average.ui.route.ListRoute
import com.hj.average.ui.route.SettingRoute
import hw.dp.route.generated.RouteExtension.Companion.route

@Module
@InstallIn(ActivityComponent::class)
object MainModule {
    @Provides
    fun provideNavigator(): NavigatorApi = NavigatorImpl()

    @Provides
    fun provideBottombarNavList(): ImmutableList<NavigationItem> = persistentListOf(
        NavigationItem(
            iconId = R.drawable.ic_home,
            titleId = R.string.bottom_menu_list,
            routeName = ListRoute.route
        ),
        NavigationItem(
            iconId = R.drawable.ic_menu,
            titleId = R.string.bottom_menu_setting,
            routeName = SettingRoute.route
        )
    )
}