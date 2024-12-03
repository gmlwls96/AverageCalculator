package com.hj.average.feature.item.list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.AddCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.hj.average.ui.theme.AppTheme
import com.hj.average.core.res.R
import com.hj.average.ui.theme.AveTheme

@Composable
internal fun ListHeader(
    modifier: Modifier = Modifier,
    onClickAdd: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(AppTheme.dimensions.height106)
            .padding(AppTheme.dimensions.padding20)
    ) {
        Icon(
            modifier = Modifier
                .align(Alignment.End)
                .size(AppTheme.dimensions.width24)
                .clickable { onClickAdd() },
            tint = MaterialTheme.colorScheme.onTertiary,
            painter = rememberVectorPainter(image = Icons.TwoTone.AddCircle),
            contentDescription = null
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = stringResource(id = R.string.list_screen_title),
            style = AppTheme.typography.noto32,
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}

@Preview
@Composable
private fun ListHeaderPreview() {
    AveTheme(isDarkTheme = false) {
        ListHeader {}
    }
}