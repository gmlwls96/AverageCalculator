package com.hj.average.feature.setting.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.stringResource
import com.hj.average.ui.theme.AppTheme

@Composable
internal fun SettingRow(
    stringRes: Int,
    onClick: () -> Unit
) {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth()
                .clickable { onClick() },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = stringRes),
                style = AppTheme.typography.noto18,
                color = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier
                    .padding(vertical = AppTheme.dimensions.padding10)
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                painter = rememberVectorPainter(image = Icons.AutoMirrored.Filled.KeyboardArrowRight),
                tint = MaterialTheme.colorScheme.onSecondary,
                contentDescription = null,
            )
        }
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(AppTheme.dimensions.height1)
                .background(MaterialTheme.colorScheme.onSecondary)
        )
    }
}