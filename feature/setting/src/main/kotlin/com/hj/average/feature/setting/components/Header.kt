package com.hj.average.feature.setting.components

import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.hj.average.core.res.R
import com.hj.average.ui.theme.AppTheme
import com.hj.average.ui.theme.AveTheme

@Composable
fun SettingHeader(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(AppTheme.dimensions.height106)
            .padding(AppTheme.dimensions.padding20)
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = stringResource(id = R.string.setting_screen_title),
            style = AppTheme.typography.noto32,
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}

@Composable
fun SettingThemeHeader(
    modifier: Modifier = Modifier,
    onBack: () -> Unit,
) {
    BackSettingHeader(
        modifier = modifier,
        titleRes = R.string.setting_screen_title,
        onBack = onBack
    )
}

@Composable
fun BugReportHeader(
    modifier: Modifier = Modifier,
    onBack: () -> Unit,
) {
    BackSettingHeader(
        modifier = modifier,
        titleRes = R.string.setting_bug,
        onBack = onBack
    )
}

@Composable
private fun BackSettingHeader(
    modifier: Modifier = Modifier,
    @StringRes titleRes: Int,
    onBack: () -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(AppTheme.dimensions.height106)
            .padding(bottom = AppTheme.dimensions.padding20)
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = AppTheme.dimensions.padding10)
                .padding(top = AppTheme.dimensions.padding20)
                .clickable { onBack() },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = rememberVectorPainter(image = Icons.AutoMirrored.Filled.KeyboardArrowLeft),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onTertiary
            )
            Text(
                text = stringResource(id = R.string.setting_screen_title),
                style = AppTheme.typography.noto14,
                color = MaterialTheme.colorScheme.onTertiary
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(
            modifier = Modifier.padding(horizontal = AppTheme.dimensions.padding20),
            text = stringResource(titleRes),
            style = AppTheme.typography.noto32,
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun SettingHeaderPreview() {
    AveTheme(isDarkTheme = false) {
        SettingHeader()
    }
}

@Preview(showBackground = true)
@Composable
private fun SettingThemeHeaderPreview() {
    AveTheme(isDarkTheme = false) {
        SettingThemeHeader(
            onBack = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun BugReportHeaderPreview() {
    AveTheme(isDarkTheme = false) {
        BugReportHeader(
            onBack = {}
        )
    }
}