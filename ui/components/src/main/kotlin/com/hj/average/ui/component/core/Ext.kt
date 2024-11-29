package com.hj.average.ui.component.core

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material.ExperimentalMaterialApi
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

fun Modifier.addFocusCleaner(focusManager: FocusManager, doOnClear: () -> Unit = {}): Modifier {
    return this.pointerInput(Unit) {
        detectTapGestures(onTap = {
            doOnClear()
            focusManager.clearFocus()
        })
    }
}

@SuppressLint("ModifierFactoryUnreferencedReceiver")
fun Modifier.bottomBorder(strokeWidth: Dp, color: Color) = composed(
    factory = {
        val density = LocalDensity.current
        val strokeWidthPx = density.run { strokeWidth.toPx() }

        Modifier.drawBehind {
            val width = size.width
            val height = size.height - strokeWidthPx / 2

            drawLine(
                color = color,
                start = Offset(x = 0f, y = height),
                end = Offset(x = width, y = height),
                strokeWidth = strokeWidthPx
            )
        }
    }
)

@Composable
fun Toast(text: String) {
    val context = LocalContext.current
    Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
}

@Composable
fun Toast(@StringRes text: Int) {
    val context = LocalContext.current
    Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
}

fun showToast(
    context: Context,
    text: String,
) {
    Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
}

fun showToast(
    context: Context,
    @StringRes text: Int,
) {
    Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
}

@Composable
fun Toast(
    key: Any?,
    @StringRes text: Int,
) {
    val context = LocalContext.current
    LaunchedEffect(key1 = key) {
        showToast(context = context, text = text)
    }
}

@ExperimentalMaterialApi
fun modalShow(
    scope: CoroutineScope,
    modalState: ModalBottomSheetState,
) {
    scope.launch {
        modalState.show()
    }
}

@ExperimentalMaterialApi
fun modalHide(
    scope: CoroutineScope,
    modalState: ModalBottomSheetState,
) {
    scope.launch {
        modalState.hide()
    }
}

@Composable
fun SpacerHeight(dp: Dp) {
    Spacer(modifier = Modifier.height(dp))
}

@Composable
fun SpacerWidth(dp: Dp) {
    Spacer(modifier = Modifier.width(dp))
}

fun LazyListState.isScrolledToEnd() = layoutInfo.visibleItemsInfo.lastOrNull()?.index == layoutInfo.totalItemsCount - 1
