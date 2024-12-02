package com.hj.average.ui.component.appstate

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import hw.dp.core.ui.navigator.api.NavigatorApi
import kotlinx.coroutines.CoroutineScope

@Composable
fun rememberAveAppState(
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    navController: NavHostController = rememberNavController(),
    navigatorApi: NavigatorApi,
): AveAppState {
    DisposableEffect(key1 = navController) {
        navigatorApi.setController(navController = navController)
        onDispose {
            navigatorApi.clear()
        }
    }
    return remember(
        navController,
        coroutineScope,
    ) {
        AveAppState(
            coroutineScope = coroutineScope,
            navigatorApi = navigatorApi,
            navController = navController
        )
    }
}

@Stable
class AveAppState(
    val navigatorApi: NavigatorApi,
    val navController: NavHostController,
    coroutineScope: CoroutineScope,
)