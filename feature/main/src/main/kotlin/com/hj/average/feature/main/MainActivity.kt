package com.hj.average.feature.main

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.hj.average.core.models.ThemeType
import com.hj.average.feature.main.components.AveApp
import com.hj.average.ui.component.appstate.rememberAveAppState
import com.hj.average.ui.component.bottombar.model.NavigationItem
import com.hj.average.ui.theme.AveTheme
import dagger.hilt.android.AndroidEntryPoint
import hw.dp.core.ui.navigator.api.NavigatorApi
import javax.inject.Inject
import kotlinx.collections.immutable.ImmutableList

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels<MainViewModel>()

    @Inject
    lateinit var navigatorApi: NavigatorApi

    @Inject
    lateinit var bottomList: ImmutableList<NavigationItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val currentTheme by viewModel.themeType.collectAsStateWithLifecycle(initialValue = ThemeType.SYSTEM)

            val aveAppState = rememberAveAppState(
                navigatorApi = navigatorApi
            )

            AveTheme(isDarkTheme = currentTheme.isDarkTheme()) {
                AveApp(
                    aveAppState = aveAppState,
                    bottomList = bottomList,
                    currentTheme = currentTheme,
                    onChangeTheme = viewModel::updateTheme
                )
            }
        }
    }

    @Composable
    private fun ThemeType.isDarkTheme() = when (this) {
        ThemeType.DARK -> true
        ThemeType.LIGHT -> false
        ThemeType.SYSTEM -> isSystemInDarkTheme()
    }
}