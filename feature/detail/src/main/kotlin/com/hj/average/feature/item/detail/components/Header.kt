package com.hj.average.feature.item.detail.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.hj.average.core.res.R
import com.hj.average.feature.item.detail.event.DetailEvent
import com.hj.average.ui.theme.AppTheme
import com.hj.average.ui.theme.AveTheme

@Composable
internal fun DetailHeader(
    modifier: Modifier = Modifier,
    title: String,
    onEvent: (DetailEvent) -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(AppTheme.dimensions.padding10),
        horizontalArrangement = Arrangement.Absolute.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier.clickable { onEvent(DetailEvent.ClickBack) },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = rememberVectorPainter(image = Icons.AutoMirrored.Filled.KeyboardArrowLeft),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onTertiary
            )
            Text(
                text = stringResource(id = R.string.detail_screen_back_text),
                style = AppTheme.typography.noto14,
                color = MaterialTheme.colorScheme.onTertiary
            )
        }
        Text(
            text = title,
            style = AppTheme.typography.noto14,
            color = MaterialTheme.colorScheme.onPrimary
        )
        Spacer(modifier = Modifier.width(AppTheme.dimensions.width10))
        Text(
            modifier = Modifier.clickable { onEvent(DetailEvent.ClickAdd) },
            text = stringResource(id = R.string.detail_screen_add),
            style = AppTheme.typography.noto14,
            color = MaterialTheme.colorScheme.onTertiary
        )
    }
}

@Preview
@Composable
private fun DetailHeaderPreview() {
    AveTheme(isDarkTheme = false) {
        Surface {
            DetailHeader(
                title = "삼성전자",
                onEvent = {}
            )
        }
    }
}