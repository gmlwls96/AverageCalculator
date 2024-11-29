package com.hj.average.ui.component.popup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.hj.average.ui.theme.AppTheme
import com.hj.average.ui.theme.Colors

@Composable
fun PbPopup(title: String, msg: String, buttonText: String, onClickButton: () -> Unit) {
    Column(
        modifier = Modifier
            .width(AppTheme.dimensions.width296)
            .heightIn(min = AppTheme.dimensions.height192)
            .background(Colors.White, shape = RoundedCornerShape(AppTheme.dimensions.radius8))
            .padding(horizontal = AppTheme.dimensions.padding24)
            .padding(top = AppTheme.dimensions.padding40, bottom = AppTheme.dimensions.padding24),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = title,
            style = AppTheme.typography.noto16
        )
        Spacer(modifier = Modifier.height(AppTheme.dimensions.height8))
        Text(
            text = msg,
            style = AppTheme.typography.noto13,
            color = Colors.Gray700
        )
        Spacer(modifier = Modifier.height(AppTheme.dimensions.height40))
        Button(
            onClick = onClickButton,
            colors = ButtonDefaults.buttonColors(
                containerColor = Colors.Black
            ),
            shape = RoundedCornerShape(AppTheme.dimensions.radius8),
            modifier = Modifier
                .height(AppTheme.dimensions.height48)
                .width(AppTheme.dimensions.width120)
        ) {
            Text(
                text = buttonText,
                color = Colors.White,
                style = AppTheme.typography.roboto14
            )
        }
    }
}

@Composable
fun PbPopup(
    modifier: Modifier = Modifier,
    title: String,
    msg: String,
    leftButtonText: String,
    onLeftClickButton: () -> Unit,
    rightButtonText: String,
    onRightClickButton: () -> Unit
) {
    Column(
        modifier = modifier
            .width(AppTheme.dimensions.width296)
            .heightIn(min = AppTheme.dimensions.height192)
            .background(Colors.White, shape = RoundedCornerShape(AppTheme.dimensions.radius8))
            .padding(horizontal = AppTheme.dimensions.padding24)
            .padding(top = AppTheme.dimensions.padding40, bottom = AppTheme.dimensions.padding24),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = title,
            style = AppTheme.typography.noto16
        )
        Spacer(modifier = Modifier.height(AppTheme.dimensions.height8))
        Text(
            text = msg,
            style = AppTheme.typography.noto13,
            color = Colors.Gray700
        )
        Spacer(modifier = Modifier.height(AppTheme.dimensions.height40))
        Row(modifier = Modifier.fillMaxWidth()) {
            Button(
                onClick = onLeftClickButton,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Colors.Gray100
                ),
                shape = RoundedCornerShape(AppTheme.dimensions.radius8),
                modifier = Modifier
                    .height(AppTheme.dimensions.height48)
                    .width(AppTheme.dimensions.width120)
            ) {
                Text(
                    text = leftButtonText,
                    color = Colors.Black,
                    style = AppTheme.typography.roboto14
                )
            }
            Spacer(modifier = Modifier.width(AppTheme.dimensions.padding8))
            Button(
                onClick = onRightClickButton,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Colors.Black
                ),
                shape = RoundedCornerShape(AppTheme.dimensions.radius8),
                modifier = Modifier
                    .height(AppTheme.dimensions.height48)
                    .width(AppTheme.dimensions.width120)
            ) {
                Text(
                    text = rightButtonText,
                    color = Colors.White,
                    style = AppTheme.typography.roboto14
                )
            }
        }
    }
}

@Preview
@Composable
fun PbPopupPreview() {
    PbPopup(
        title = "Title",
        msg = "body",
        buttonText = "button"
    ) {
    }
}

@Preview
@Composable
fun PbPopupPreview2() {
    PbPopup(
        title = "Title",
        msg = "body",
        leftButtonText = "Left",
        onLeftClickButton = {},
        rightButtonText = "Right"
    ) {
    }
}