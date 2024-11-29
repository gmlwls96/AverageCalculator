package com.hj.average.ui.component.bottomsheet

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import com.hj.average.ui.theme.AppTheme

@ExperimentalMaterialApi
@Composable
fun ModalBottomSheetWrapper(
    modifier: Modifier = Modifier,
    modalState: ModalBottomSheetState,
    sheetShape: Shape = RoundedCornerShape(
        topStart = AppTheme.dimensions.radius16,
        topEnd = AppTheme.dimensions.radius16
    ),
    sheetGesturesEnabled: Boolean = true,
    sheetContent: (@Composable () -> Unit)?,
    content: @Composable () -> Unit,
) {
    ModalBottomSheetLayout(
        modifier = modifier.fillMaxSize(),
        sheetShape = sheetShape,
        sheetState = modalState,
        sheetContent = {
            sheetContent?.invoke()
        },
        sheetGesturesEnabled = sheetGesturesEnabled,
        content = content
    )
}