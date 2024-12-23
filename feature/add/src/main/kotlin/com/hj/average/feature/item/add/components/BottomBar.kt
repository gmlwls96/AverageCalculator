package com.hj.average.feature.item.add.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.hj.average.core.res.R
import com.hj.average.ui.component.buttons.BasicButton
import com.hj.average.ui.theme.AppTheme

@Composable
internal fun BottomBtn(
    modifier: Modifier = Modifier,
    isEnable: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                horizontal = AppTheme.dimensions.padding10,
                vertical = AppTheme.dimensions.padding20
            )
    ) {
        BasicButton(
            modifier = Modifier
                .fillMaxWidth(),
            stringResId = R.string.item_add_save,
            isEnable = isEnable,
            bgColor = if (isEnable) {
                MaterialTheme.colorScheme.onTertiary
            } else {
                MaterialTheme.colorScheme.onSecondary
            },
            onClick = onClick
        )
    }
}