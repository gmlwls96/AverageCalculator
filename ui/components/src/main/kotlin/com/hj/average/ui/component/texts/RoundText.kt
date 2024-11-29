package com.hj.average.ui.component.texts

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.hj.average.ui.theme.AppTheme
import com.hj.average.ui.theme.Colors

@Composable
fun RoundText(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color = Colors.FintaBlue,
    bgColor: Color = Colors.Finta100,
    borderColor: Color = Colors.Transparent
) {
    Text(
        text = text,
        modifier = Modifier
            .clip(shape = RoundedCornerShape(Size.TV_ROUND_CORNER))
            .border(width = 1.dp, color = borderColor, shape = RoundedCornerShape(Size.TV_ROUND_CORNER))
            .background(bgColor)
            .padding(
                horizontal = Size.TV_ROUND_H_PADDING,
                vertical = Size.TV_ROUND_V_PADDING
            )
            .then(modifier),
        color = textColor,
        style = AppTheme.typography.noto13
    )
}