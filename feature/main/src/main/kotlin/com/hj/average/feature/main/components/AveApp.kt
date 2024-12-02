package com.hj.average.feature.main.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.hj.average.feature.item.list.nav.itemListScreen
import com.hj.average.ui.component.appstate.AveAppState
import com.hj.average.ui.route.ListRoute
import hw.dp.route.generated.RouteExtension.Companion.route

@Composable
fun AveApp(
    aveAppState: AveAppState,
    onChangeTheme: (String) -> Unit
) {
    AveNavHost(
        aveAppState,
        onChangeTheme = onChangeTheme
    )
}

@Suppress("UnusedParameter")
@Composable
fun AveNavHost(
    aveAppState: AveAppState,
    onChangeTheme: (String) -> Unit
) {
    val navController = aveAppState.navController
    Scaffold {
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
            }
        }
    }
}