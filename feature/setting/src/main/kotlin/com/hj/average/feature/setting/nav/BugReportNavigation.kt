package com.hj.average.feature.setting.nav

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.hj.average.feature.setting.BugReportScreen
import com.hj.average.ui.route.BugReportRoute
import hw.dp.route.generated.RouteExtension.Companion.args
import hw.dp.route.generated.RouteExtension.Companion.route

fun NavGraphBuilder.bugReportScreen(
    modifier: Modifier = Modifier,
    onBack: () -> Unit
) {
    composable(
        route = BugReportRoute.route,
        arguments = BugReportRoute.args
    ) {
        BugReportScreen(
            modifier = modifier,
            onBack = onBack
        )
    }
}