package com.hj.average.ui.component.buttons

import androidx.annotation.StringRes
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import com.hj.average.ui.theme.AppTheme
import com.hj.average.ui.theme.Colors

@Composable
fun BasicButton(
    modifier: Modifier = Modifier,
    @StringRes stringResId: Int,
    textStyle: TextStyle = AppTheme.typography.bottomBt,
    bgColor: Color = Colors.Gray900,
    textColor: Color = Colors.White,
    isEnable: Boolean = true,
    shape: Shape = RectangleShape,
    onClick: () -> Unit,
) {
    val interactionSource = remember {
        MutableInteractionSource()
    }

    val fontColor = if (isEnable) textColor else Colors.Gray600
    val maxModifier = Modifier.fillMaxWidth()
    TextButton(
        modifier = maxModifier
            .height(AppTheme.dimensions.height56)
            .then(modifier),
        shape = shape,
        enabled = isEnable,
        colors = ButtonDefaults.buttonColors(
            containerColor = bgColor,
            disabledContainerColor = Colors.Gray400
        ),
        onClick = onClick,
        interactionSource = interactionSource
    ) {
        Text(
            modifier = maxModifier,
            text = stringResource(id = stringResId),
            style = textStyle,
            color = fontColor,
        )
    }
}

@Composable
fun BasicButton(
    modifier: Modifier = Modifier,
    buttonText: String,
    textStyle: TextStyle = AppTheme.typography.bottomBt,
    bgColor: Color = Colors.Gray900,
    textColor: Color = Colors.White,
    isEnable: Boolean = true,
    shape: Shape = RectangleShape,
    onClick: () -> Unit,
) {
    val interactionSource = remember {
        MutableInteractionSource()
    }

    val fontColor = if (isEnable) textColor else Colors.Gray600
    val maxModifier = Modifier.fillMaxWidth()
    TextButton(
        modifier = maxModifier
            .height(AppTheme.dimensions.height56)
            .then(modifier),
        shape = shape,
        enabled = isEnable,
        colors = ButtonDefaults.buttonColors(
            containerColor = bgColor,
            disabledContainerColor = Colors.Gray400
        ),
        onClick = onClick,
        interactionSource = interactionSource
    ) {
        Text(
            modifier = maxModifier,
            text = buttonText,
            style = textStyle,
            color = fontColor,
        )
    }
}