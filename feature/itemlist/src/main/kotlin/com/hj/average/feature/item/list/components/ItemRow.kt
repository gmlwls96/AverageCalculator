package com.hj.average.feature.item.list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.hj.average.feature.item.list.vo.ItemVo
import com.hj.average.ui.theme.AppTheme
import com.hj.average.core.res.R
import com.hj.average.ui.component.core.SpacerHeight
import com.hj.average.ui.theme.AveTheme
import com.hj.average.ui.theme.Colors
import java.text.DecimalFormat

@Suppress("LongMethod")
@Composable
internal fun ItemRow(
    modifier: Modifier = Modifier,
    itemVo: ItemVo,
    format: DecimalFormat = DecimalFormat("#,###.00"),
    onClick: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = AppTheme.dimensions.padding10)
            .clickable { onClick() }
    ) {
        Row {
            Text(
                text = itemVo.title,
                style = AppTheme.typography.noto16,
                color = MaterialTheme.colorScheme.onPrimary
            )
            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = format.format(itemVo.averagePrice),
                style = AppTheme.typography.noto20,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }

        Row {
            Text(
                text = itemVo.date,
                style = AppTheme.typography.noto12,
                color = MaterialTheme.colorScheme.onSecondary
            )
            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = String.format(stringResource(id = R.string.double_percent_format), itemVo.profit),
                style = AppTheme.typography.noto13,
                color = if (itemVo.profit > 0) {
                    Colors.RED200
                } else {
                    Colors.Blue100
                }
            )
        }
        SpacerHeight(dp = AppTheme.dimensions.padding10)
        Row {
            Text(
                text = stringResource(id = R.string.total_purchase_price),
                style = AppTheme.typography.noto15,
                color = MaterialTheme.colorScheme.onPrimary
            )
            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = format.format(itemVo.totalPurchasePrice),
                style = AppTheme.typography.noto15,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
        SpacerHeight(dp = AppTheme.dimensions.padding10)
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(AppTheme.dimensions.height1)
                .background(MaterialTheme.colorScheme.onSecondary)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ItemRowPreview() {
    AveTheme(
        isDarkTheme = false
    ) {
        ItemRow(
            itemVo = ItemVo(
                id = 0,
                title = "삼성전자",
                date = "2024-11-25",
                averagePrice = 54750.00,
                profit = 10.23,
                totalPurchasePrice = 2189999.99
            ),
            onClick = {}
        )
    }
}