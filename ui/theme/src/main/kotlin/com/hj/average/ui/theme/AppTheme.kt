package com.hj.average.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable

object AppTheme {
    val typography: AppTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current
    val dimensions: AppDimensions
        @Composable
        @ReadOnlyComposable
        get() = LocalDimensions.current
}