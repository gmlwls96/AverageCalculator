package com.hj.average.ui.component.checkbox

import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.hj.average.ui.theme.AppTheme
import com.hj.average.ui.theme.Colors

@Composable
fun IconCheckBox(
    modifier: Modifier = Modifier,
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    tintColor: Color = Colors.FintaBlue,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val ripple = rememberRipple(bounded = false)
    IconButton(
        modifier = modifier
            .size(AppTheme.dimensions.width40)
            .indication(interactionSource, ripple),
        onClick = { onCheckedChange(!isChecked) }
    ) {
        if (isChecked) {
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = null,
                tint = tintColor
            )
        } else {
            Icon(
                imageVector = Icons.Outlined.Check,
                contentDescription = null,
                tint = Colors.Gray600
            )
        }
    }
}