package com.hj.average.feature.main

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.hj.average.feature.main.components.AveApp
import com.hj.average.ui.component.appstate.rememberAveAppState
import com.hj.average.ui.theme.AveTheme
import dagger.hilt.android.AndroidEntryPoint
import hw.dp.core.ui.navigator.api.NavigatorApi
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var navigatorApi: NavigatorApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            var isDarkTheme by remember {
                mutableStateOf(false)
            }

            val aveAppState = rememberAveAppState(
                navigatorApi = navigatorApi
            )

            AveTheme(isDarkTheme = isDarkTheme) {
                AveApp(
                    aveAppState = aveAppState,
                    onChangeTheme = {}
                )
            }
        }
    }
}