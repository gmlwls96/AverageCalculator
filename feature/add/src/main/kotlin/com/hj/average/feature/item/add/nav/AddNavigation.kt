package com.hj.average.feature.item.add.nav

import androidx.compose.animation.EnterTransition
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.hj.average.feature.item.add.AddScreen
import com.hj.average.ui.route.AddRoute
import hw.dp.route.generated.RouteExtension.Companion.args
import hw.dp.route.generated.RouteExtension.Companion.route

fun NavGraphBuilder.addScreen() {
    composable(
        route = AddRoute.route,
        arguments = AddRoute.args,
        enterTransition = { EnterTransition.None }
    ) {
        AddScreen()
    }
}