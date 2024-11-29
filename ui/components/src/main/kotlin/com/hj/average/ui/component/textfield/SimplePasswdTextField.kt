package com.hj.average.ui.component.textfield

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import com.hj.average.ui.theme.AppTheme
import com.hj.average.ui.theme.Colors

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SimplePasswdTextField(
    modifier: Modifier = Modifier,
    passwdText: String,
    passwdCount: Int = 6,
    onPasswdTextChange: (String, Boolean) -> Unit,
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusRequester = remember {
        FocusRequester()
    }

    BasicTextField(
        modifier = modifier
            .focusRequester(focusRequester)
            .onFocusChanged {
                if (it.isFocused) {
                    keyboardController?.show()
                }
            },
        value = TextFieldValue(text = passwdText, selection = TextRange(passwdText.length)),
        onValueChange = {
            if (it.text.length <= passwdCount) {
                onPasswdTextChange.invoke(it.text, it.text.length == passwdCount)
            }
        },
        keyboardOptions =
        KeyboardOptions(
            keyboardType = KeyboardType.NumberPassword,
            capitalization = KeyboardCapitalization.Characters,
        ),
        decorationBox = {
            Row(
                horizontalArrangement = Arrangement.Center
            ) {
                repeat(passwdCount) { index ->
                    NumberText(
                        index = index,
                        text = passwdText
                    )
                    Spacer(modifier = Modifier.width(AppTheme.dimensions.padding8))
                }
            }
        },
    )

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }
}

@Composable
private fun NumberText(
    index: Int,
    text: String,
) {
    val bg = when {
        index < text.length -> Colors.Black
        else -> Colors.Gray400
    }

    val modifier = Modifier.size(
        AppTheme.dimensions.width20
    )

    Box(modifier = modifier) {
        Canvas(modifier = modifier, onDraw = {
            drawCircle(color = bg)
        })
        Text(text = "")
    }
}