package com.hj.average.feature.setting.nav

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.hj.average.feature.setting.SettingScreen
import com.hj.average.ui.route.SettingRoute
import hw.dp.route.generated.RouteExtension.Companion.args
import hw.dp.route.generated.RouteExtension.Companion.route

fun NavGraphBuilder.settingScreen() {
    composable(
        route = SettingRoute.route,
        arguments = SettingRoute.args
    ) {
        SettingScreen()
    }
}