package com.hj.average.feature.item.detail.nav

import androidx.compose.animation.EnterTransition
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.hj.average.feature.item.detail.DetailScreen
import com.hj.average.ui.route.ListRoute
import hw.dp.route.generated.RouteExtension.Companion.args
import hw.dp.route.generated.RouteExtension.Companion.route

fun NavGraphBuilder.detailScreen() {
    composable(
        route = ListRoute.route,
        arguments = ListRoute.args,
        enterTransition = { EnterTransition.None }
    ) {
        DetailScreen()
    }
}