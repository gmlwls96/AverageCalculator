package com.hj.average.feature.item.add.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import com.hj.average.core.res.R
import com.hj.average.ui.theme.AppTheme

@Composable
internal fun AddHeader(
    modifier: Modifier = Modifier,
    onBack: () -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(AppTheme.dimensions.height106)
            .padding(
                horizontal = AppTheme.dimensions.padding10,
                vertical = AppTheme.dimensions.padding20
            )
    ) {
        Icon(
            modifier = Modifier
                .align(Alignment.Start)
                .size(AppTheme.dimensions.width24)
                .clickable { onBack() },
            tint = MaterialTheme.colorScheme.onTertiary,
            painter = rememberVectorPainter(image = Icons.AutoMirrored.Filled.KeyboardArrowLeft),
            contentDescription = null
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            modifier = Modifier.padding(horizontal = AppTheme.dimensions.padding10),
            text = stringResource(id = R.string.item_add_title),
            style = AppTheme.typography.noto32,
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}