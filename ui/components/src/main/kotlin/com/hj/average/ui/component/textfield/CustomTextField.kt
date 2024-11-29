package com.hj.average.ui.component.textfield

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import com.hj.average.ui.component.core.bottomBorder
import com.hj.average.ui.theme.AppTheme
import com.hj.average.ui.theme.Colors

@ExperimentalComposeUiApi
@Suppress("LongParameterList", "LongMethod")
@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    inputText: String,
    onTextChange: (String) -> Unit,
    maxLength: Int,
    focusRequester: FocusRequester = FocusRequester(),
    labelText: String?,
    isEnable: Boolean = true,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
) {
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current
    var isFocused by remember { mutableStateOf(false) }
    val keyboardAction = {
        keyboardController?.hide()
        focusManager.clearFocus()
        isFocused = false
        keyboardActions?.invoke()
    }

    val maxWidthModifier = Modifier
        .fillMaxWidth()

    Box(
        modifier = modifier
            .bottomBorder(
                strokeWidth = AppTheme.dimensions.width1,
                color = if (isFocused) Colors.Black else Colors.Gray400
            )
            .padding(bottom = AppTheme.dimensions.padding2)
    ) {
        BasicTextField(
            enabled = isEnable,
            value = inputText,
            singleLine = true,
            visualTransformation = visualTransformation,
            maxLines = 1,
            keyboardOptions = keyboardOptions,
            keyboardActions = KeyboardActions(
                onDone = { keyboardAction.invoke() },
                onNext = { keyboardAction.invoke() },
            ),
            onValueChange = {
                if (it.length <= maxLength) {
                    onTextChange(it)
                }
            },
            textStyle = AppTheme.typography.customTextField,
            modifier = maxWidthModifier
                .height(AppTheme.dimensions.height56)
                .background(Color.White)
                .onFocusChanged { isFocused = it.isFocused }
                .focusRequester(focusRequester),
        ) { inputTextField ->
            val offsetAnimation: Dp by animateDpAsState(
                targetValue = if (inputText.isEmpty()) {
                    Dimensions.OFFSET_0
                } else {
                    -Dimensions.OFFSET_10
                },
                animationSpec = spring(dampingRatio = Spring.DampingRatioLowBouncy),
                label = ""
            )

            val fontStyle = if (inputText.isEmpty()) {
                AppTheme.typography.noto20Regular
            } else {
                AppTheme.typography.noto14Regular
            }

            val offSet = if (inputText.isEmpty() && !labelText.isNullOrEmpty()) {
                Dimensions.OFFSET_0
            } else {
                Dimensions.OFFSET_10
            }

            Box(
                modifier = maxWidthModifier,
                contentAlignment = Alignment.CenterStart
            ) {
                labelText?.let {
                    Text(
                        modifier = Modifier.absoluteOffset(y = offsetAnimation),
                        text = labelText,
                        style = fontStyle
                    )
                }

                Box(Modifier.offset(y = offSet)) {
                    inputTextField()
                }
            }
        }
    }
}