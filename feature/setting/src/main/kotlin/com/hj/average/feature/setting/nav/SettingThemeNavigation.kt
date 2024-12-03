package com.hj.average.feature.setting.nav

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.hj.average.core.models.ThemeType
import com.hj.average.feature.setting.SettingThemeScreen
import com.hj.average.ui.route.SettingThemeRoute
import hw.dp.route.generated.RouteExtension.Companion.args
import hw.dp.route.generated.RouteExtension.Companion.route

fun NavGraphBuilder.settingThemeScreen(
    currentTheme: ThemeType,
    onBack: () -> Unit,
    onChangeTheme: (ThemeType) -> Unit,
) {
    composable(
        route = SettingThemeRoute.route,
        arguments = SettingThemeRoute.args,
    ) {
        SettingThemeScreen(
            currentTheme = currentTheme,
            onBack = onBack,
            onChangeTheme = onChangeTheme
        )
    }
}