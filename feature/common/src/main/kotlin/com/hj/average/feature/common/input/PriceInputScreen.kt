package com.hj.average.feature.common.input

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.hj.average.ui.component.core.SpacerHeight
import com.hj.average.ui.theme.AppTheme
import com.hj.average.core.res.R
import com.hj.average.ui.component.core.addFocusCleaner
import com.hj.average.ui.theme.AveTheme

@Suppress("LongParameterList")
@Composable
fun PriceInputScreen(
    modifier: Modifier = Modifier,
    focusManager: FocusManager = LocalFocusManager.current,
    title: String,
    onTitleChange: (String) -> Unit,
    firstPrice: String,
    onFirstPriceChange: (String) -> Unit,
    firstQuantity: String,
    onFirstQuantityChange: (String) -> Unit,
    secondPrice: String,
    onSecondPriceChange: (String) -> Unit,
    secondQuantity: String,
    onSecondQuantityChange: (String) -> Unit,
) {
    Column(modifier = modifier.addFocusCleaner(focusManager)) {
        CustomOutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = title,
            onValueChange = onTitleChange,
            hintTextRes = R.string.input_name_hint
        )

        Text(
            text = stringResource(id = R.string.first_buy),
            style = AppTheme.typography.noto18,
            color = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier
                .padding(AppTheme.dimensions.padding10)
                .padding(top = AppTheme.dimensions.padding30)
        )
        CustomOutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = firstPrice,
            onValueChange = onFirstPriceChange,
            hintTextRes = R.string.input_first_price_hint,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        SpacerHeight(dp = AppTheme.dimensions.padding10)
        CustomOutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = firstQuantity,
            onValueChange = onFirstQuantityChange,
            hintTextRes = R.string.input_first_quantity_hint,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Text(
            text = stringResource(id = R.string.second_buy),
            style = AppTheme.typography.noto18,
            color = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier
                .padding(AppTheme.dimensions.padding10)
                .padding(top = AppTheme.dimensions.padding30)
        )
        CustomOutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = secondPrice,
            onValueChange = onSecondPriceChange,
            hintTextRes = R.string.input_second_price_hint,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        SpacerHeight(dp = AppTheme.dimensions.padding10)
        CustomOutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = secondQuantity,
            onValueChange = onSecondQuantityChange,
            hintTextRes = R.string.input_second_quantity_hint,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PriceInputScreenPreview() {
    AveTheme(isDarkTheme = true) {
        Surface(Modifier.fillMaxSize()) {
            PriceInputScreen(
                modifier = Modifier.padding(AppTheme.dimensions.padding10),
                title = "삼성 전자",
                onTitleChange = {},
                firstPrice = "5000",
                onFirstPriceChange = {},
                firstQuantity = "10",
                onFirstQuantityChange = {},
                secondPrice = "",
                onSecondPriceChange = {},
                secondQuantity = "",
                onSecondQuantityChange = {}
            )
        }
    }
}