package com.hj.average.feature.item.detail.nav

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.hj.average.feature.item.detail.DetailScreen
import com.hj.average.ui.route.DetailRoute
import hw.dp.route.generated.RouteExtension.Companion.args
import hw.dp.route.generated.RouteExtension.Companion.route

fun NavGraphBuilder.detailScreen() {
    composable(
        route = DetailRoute.route,
        arguments = DetailRoute.args,
    ) {
        DetailScreen()
    }
}