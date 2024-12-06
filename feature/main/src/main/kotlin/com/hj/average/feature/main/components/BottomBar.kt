package com.hj.average.feature.main.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.hj.average.ui.component.bottombar.BottomNavigationBar
import com.hj.average.ui.component.bottombar.model.NavigationItem
import kotlinx.collections.immutable.ImmutableList

@Composable
fun MainBottomBar(
    navController: NavController,
    bottomList: ImmutableList<NavigationItem>,
    onClickBottomTab: (NavigationItem) -> Unit,
) {
    val isShow by rememberBottomShowState(navController, bottomList)
    if (isShow) {
        BottomNavigationBar(
            navController = navController,
            screenList = bottomList,
            onClickBottomTab = onClickBottomTab
        )
    }
}

@Composable
fun rememberBottomShowState(
    navController: NavController,
    bottomList: ImmutableList<NavigationItem>,
): State<Boolean> {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val routeList = bottomList.map { it.routeName }
    return remember(navBackStackEntry, routeList) {
        mutableStateOf(routeList.contains(navBackStackEntry?.destination?.route))
    }
}