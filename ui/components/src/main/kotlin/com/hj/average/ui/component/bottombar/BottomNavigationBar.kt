package com.hj.average.ui.component.bottombar

import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.hj.average.ui.component.bottombar.model.NavigationItem
import com.hj.average.ui.theme.Colors
import kotlinx.collections.immutable.ImmutableList

@Composable
fun BottomNavigationBar(
    navController: NavController,
    screenList: ImmutableList<NavigationItem>,
    containerColor: Color = Color.White,
    colors: NavigationBarItemColors = NavigationBarItemDefaults.colors(
        selectedIconColor = Colors.Gray1000,
        unselectedIconColor = Colors.Gray600,
        selectedTextColor = Colors.Gray1000,
        unselectedTextColor = Colors.Gray700,
        indicatorColor = Colors.White
    ),
    onClickBottomTab: (NavigationItem) -> Unit,
) {
    NavigationBar(
        modifier = Modifier.navigationBarsPadding(),
        containerColor = containerColor,
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        screenList.forEach { screen ->
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(id = screen.iconId),
                        contentDescription = stringResource(id = screen.titleId)
                    )
                },
                label = {
                    Text(text = stringResource(id = screen.titleId))
                },
                alwaysShowLabel = true,
                selected = currentDestination?.hierarchy?.any { it.route == screen.routeName } == true,
                colors = colors,
                onClick = {
                    if (currentDestination?.route != screen.routeName) {
                        navController.navigate(screen.routeName) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                        onClickBottomTab(screen)
                    }
                }
            )
        }
    }
}
