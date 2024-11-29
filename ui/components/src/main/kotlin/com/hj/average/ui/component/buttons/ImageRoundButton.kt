package com.hj.average.ui.component.buttons

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.hj.average.ui.theme.AppTheme
import com.hj.average.ui.theme.Colors
import com.hj.average.core.res.R

@Suppress("LongParameterList")
@Composable
fun ImageRoundButton(
    modifier: Modifier = Modifier,
    @StringRes stringResId: Int,
    @DrawableRes drawableResId: Int,
    textStyle: TextStyle = AppTheme.typography.bottomBt,
    bgColor: Color = Colors.Gray900,
    textColor: Color = Colors.White,
    drawableColor: Color = Colors.White,
    shape: Shape = RoundedCornerShape(AppTheme.dimensions.radius8),
    isEnable: Boolean = true,
    textAlign: TextAlign = TextAlign.Center,
    drawableAlignment: Alignment = Alignment.CenterEnd,
    onClick: () -> Unit,
) {
    val fontColor = if (isEnable) textColor else Colors.Gray600
    val maxModifier = Modifier.fillMaxWidth()

    TextButton(
        modifier = maxModifier
            .then(modifier),
        shape = shape,
        enabled = isEnable,
        colors = ButtonDefaults.buttonColors(
            containerColor = bgColor,
            disabledContainerColor = Colors.Gray400
        ),
        contentPadding = PaddingValues(
            horizontal = AppTheme.dimensions.padding16,
            vertical = AppTheme.dimensions.padding14
        ),
        onClick = onClick
    ) {
        Box {
            Text(
                modifier = maxModifier,
                text = stringResource(id = stringResId),
                style = textStyle,
                color = fontColor,
                textAlign = textAlign
            )

            Image(
                painter = painterResource(id = drawableResId),
                contentDescription = null,
                modifier = Modifier.align(drawableAlignment),
                colorFilter = ColorFilter.tint(color = drawableColor)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ImageRoundButtonBasicPreview() {
    ImageRoundButton(
        stringResId = R.string.confirm,
        drawableResId = R.drawable.ic_arrow_right
    ) {}
}

@Preview(showBackground = true)
@Composable
fun ImageRoundButtonTextAlignPreview() {
    ImageRoundButton(
        stringResId = R.string.confirm,
        drawableResId = R.drawable.ic_arrow_right,
        textAlign = TextAlign.Start
    ) {}
}