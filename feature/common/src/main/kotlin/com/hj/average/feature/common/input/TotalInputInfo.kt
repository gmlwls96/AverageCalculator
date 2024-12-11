package com.hj.average.feature.common.input

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.hj.average.core.res.R
import com.hj.average.feature.common.string.percentString
import com.hj.average.feature.common.string.thousandsCommaString
import com.hj.average.ui.theme.AppTheme
import com.hj.average.ui.theme.AveTheme

@Composable
fun TotalInputInfo(
    modifier: Modifier = Modifier,
    totalQuantity: String,
    totalAveragePrice: String,
    totalProfit: String,
    totalPrice: String
) {
    Column(modifier = modifier.fillMaxWidth()) {
        TotalRow(
            titleRes = R.string.total_quantity,
            value = thousandsCommaString(totalQuantity)
        )
        TotalRow(
            titleRes = R.string.total_average_price,
            value = thousandsCommaString(totalAveragePrice)
        )
        TotalRow(
            titleRes = R.string.total_profit,
            value = percentString(totalProfit)
        )
        TotalRow(
            titleRes = R.string.total_buy_price,
            value = thousandsCommaString(totalPrice)
        )
    }
}

@Composable
fun TotalRow(
    modifier: Modifier = Modifier,
    @StringRes titleRes: Int,
    value: String,
) {
    Row(
        modifier = modifier.padding(AppTheme.dimensions.padding4),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(id = titleRes),
            color = MaterialTheme.colorScheme.onPrimary,
            style = AppTheme.typography.noto15,
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = value,
            color = MaterialTheme.colorScheme.onPrimary,
            style = AppTheme.typography.noto15,
        )
    }
}

@Preview
@Composable
private fun TotalInputInfoPreview() {
    AveTheme(isDarkTheme = true) {
        Surface {
            TotalInputInfo(
                totalQuantity = "40",
                totalAveragePrice = "54,750",
                totalProfit = "100%",
                totalPrice = "2,190,000"
            )
        }
    }
}