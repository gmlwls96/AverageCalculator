package com.hj.average.ui.component.buttons

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import com.hj.average.ui.theme.AppTheme
import com.hj.average.ui.theme.Colors
import com.hj.average.core.res.R

@Composable
fun RoundButton(
    modifier: Modifier = Modifier,
    @StringRes stringResId: Int = R.string.confirm,
    @DrawableRes drawableRes: Int? = null,
    bgColor: Color = Colors.Gray900,
    textColor: Color = Colors.White,
    shape: Shape = RoundedCornerShape(AppTheme.dimensions.radius8),
    border: BorderStroke? = null,
    isEnable: Boolean = true,
    onClick: () -> Unit,
) {
    BasicButton(
        modifier = modifier,
        stringResId = stringResId,
        drawableRes = drawableRes,
        bgColor = bgColor,
        shape = shape,
        border = border,
        textColor = textColor,
        isEnable = isEnable,
        onClick = onClick
    )
}

@Composable
fun RoundButton(
    modifier: Modifier = Modifier,
    buttonText: String,
    bgColor: Color = Colors.Gray900,
    textColor: Color = Colors.White,
    shape: Shape = RoundedCornerShape(AppTheme.dimensions.radius8),
    isEnable: Boolean = true,
    onClick: () -> Unit,
) {
    BasicButton(
        modifier = modifier,
        bgColor = bgColor,
        shape = shape,
        textColor = textColor,
        isEnable = isEnable,
        buttonText = buttonText,
        onClick = onClick
    )
}