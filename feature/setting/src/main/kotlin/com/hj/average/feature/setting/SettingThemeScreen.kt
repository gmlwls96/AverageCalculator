package com.hj.average.feature.setting

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.hj.average.core.models.ThemeType
import com.hj.average.core.res.R
import com.hj.average.feature.setting.components.SettingThemeHeader
import com.hj.average.ui.component.buttons.RoundButton
import com.hj.average.ui.component.core.SpacerHeight
import com.hj.average.ui.component.core.SpacerWidth
import com.hj.average.ui.theme.AppTheme
import com.hj.average.ui.theme.AveTheme
import com.hj.average.ui.theme.Colors

@Composable
fun SettingThemeScreen(
    currentTheme: ThemeType,
    onBack: () -> Unit,
    onChangeTheme: (ThemeType) -> Unit,
) {
    Scaffold(
        topBar = {
            SettingThemeHeader(onBack = onBack)
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(horizontal = AppTheme.dimensions.padding20)
        ) {
            Text(
                text = String.format(
                    stringResource(id = R.string.setting_theme_current),
                    stringResource(id = currentTheme.themeTypeToStringRes())
                ),
                style = AppTheme.typography.noto18,
                color = MaterialTheme.colorScheme.onPrimary
            )
            SpacerHeight(dp = AppTheme.dimensions.padding20)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ThemeRoundBtn(
                    modifier = Modifier.weight(1f),
                    stringResId = R.string.setting_theme_dark,
                    currentTheme = currentTheme,
                    onClick = { onChangeTheme(ThemeType.DARK) }
                )
                SpacerWidth(dp = AppTheme.dimensions.padding10)
                ThemeRoundBtn(
                    modifier = Modifier.weight(1f),
                    stringResId = R.string.setting_theme_light,
                    currentTheme = currentTheme,
                    onClick = { onChangeTheme(ThemeType.LIGHT) }
                )
                SpacerWidth(dp = AppTheme.dimensions.padding10)
                ThemeRoundBtn(
                    modifier = Modifier.weight(1f),
                    stringResId = R.string.setting_theme_system,
                    currentTheme = currentTheme,
                    onClick = { onChangeTheme(ThemeType.SYSTEM) }
                )
            }
        }
    }
}

@Composable
private fun ThemeRoundBtn(
    modifier: Modifier = Modifier,
    stringResId: Int,
    currentTheme: ThemeType,
    onClick: () -> Unit
) {
    val currentThemeStringRes = currentTheme.themeTypeToStringRes()
    val isSelect = currentThemeStringRes == stringResId
    RoundButton(
        modifier = modifier,
        stringResId = stringResId,
        onClick = onClick,
        textColor = if (isSelect) {
            Colors.White
        } else {
            Colors.Gray1000
        },
        bgColor = if (isSelect) {
            Colors.Gray600
        } else {
            Colors.White
        },
        border = BorderStroke(
            width = AppTheme.dimensions.width1,
            color = if (isSelect) {
                Colors.FintaBlue
            } else {
                Colors.Gray900
            }
        )
    )
}

private fun ThemeType.themeTypeToStringRes() =
    when (this) {
        ThemeType.DARK -> R.string.setting_theme_dark
        ThemeType.LIGHT -> R.string.setting_theme_light
        else -> R.string.setting_theme_system
    }

@Preview
@Composable
private fun SettingThemeScreenPreview() {
    AveTheme(isDarkTheme = false) {
        SettingThemeScreen(
            currentTheme = ThemeType.DARK,
            onBack = {},
            onChangeTheme = {}
        )
    }
}