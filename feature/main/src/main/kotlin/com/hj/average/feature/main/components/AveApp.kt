package com.hj.average.feature.main.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.hj.average.core.models.ThemeType
import com.hj.average.feature.item.add.nav.addScreen
import com.hj.average.feature.item.detail.nav.detailScreen
import com.hj.average.feature.item.list.nav.itemListScreen
import com.hj.average.feature.setting.nav.bugReportScreen
import com.hj.average.feature.setting.nav.settingScreen
import com.hj.average.feature.setting.nav.settingThemeScreen
import com.hj.average.ui.component.appstate.AveAppState
import com.hj.average.ui.component.bottombar.model.NavigationItem
import com.hj.average.ui.route.ListRoute
import hw.dp.route.generated.RouteExtension.Companion.route
import kotlinx.collections.immutable.ImmutableList

@Composable
fun AveApp(
    aveAppState: AveAppState,
    currentTheme: ThemeType,
    bottomList: ImmutableList<NavigationItem>,
    onChangeTheme: (ThemeType) -> Unit
) {
    AveNavHost(
        aveAppState = aveAppState,
        bottomList = bottomList,
        currentTheme = currentTheme,
        onChangeTheme = onChangeTheme
    )
}

@Composable
fun AveNavHost(
    aveAppState: AveAppState,
    bottomList: ImmutableList<NavigationItem>,
    currentTheme: ThemeType,
    onChangeTheme: (ThemeType) -> Unit
) {
    val navController = aveAppState.navController
    Scaffold(
        bottomBar = {
            MainBottomBar(
                navController = navController,
                bottomList = bottomList,
                onClickBottomTab = {}
            )
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            NavHost(
                navController = navController,
                startDestination = ListRoute.route
            ) {
                itemListScreen()

                settingScreen()

                settingThemeScreen(
                    currentTheme = currentTheme,
                    onBack = { aveAppState.navigatorApi.popBackStack() },
                    onChangeTheme = onChangeTheme
                )

                detailScreen()

                addScreen()

                bugReportScreen(
                    onBack = { aveAppState.navigatorApi.popBackStack() }
                )
            }
        }
    }
}