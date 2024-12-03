package com.hj.average.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.ViewCompat
import com.hj.average.ui.theme.Colors.Gray100
import com.hj.average.ui.theme.Colors.Gray900
import com.hj.average.ui.theme.Colors.PurpleGrey40
import com.hj.average.ui.theme.Colors.PurpleGrey80

private val DarkColorScheme = darkColorScheme(
    primary = Gray900,
    onPrimary = Gray100, // text
    secondary = PurpleGrey80,
    onSecondary = Colors.Gray600,
    background = Gray900,
    onTertiary = Colors.Blue100,
    onSurface = Colors.White,
    surfaceBright = Colors.White_45
)

private val LightColorScheme = lightColorScheme(
    primary = Gray100,
    onPrimary = Colors.Gray1000,
    secondary = PurpleGrey40,
    onSecondary = Colors.Gray600,
    background = Gray100,
    onTertiary = Colors.Blue100,
    onSurface = Colors.Black,
    surfaceBright = Colors.Black_45
)

@Composable
fun PbTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    typography: AppTypography = AppTheme.typography,
    dimensions: AppDimensions = AppTheme.dimensions,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            (view.context as Activity).window.statusBarColor = colorScheme.primary.toArgb()
            ViewCompat.getWindowInsetsController(view)?.isAppearanceLightStatusBars = darkTheme
        }
    }

    CompositionLocalProvider(
        LocalDimensions provides dimensions,
        LocalTypography provides typography
    ) {
        content()
    }
}

@Composable
fun AveTheme(
    isDarkTheme: Boolean,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (isDarkTheme) {
            DarkColorScheme
        } else {
            LightColorScheme
        },
        content = content
    )
}