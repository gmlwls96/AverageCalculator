package com.hj.average.feature.item.list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun SwipeToDismissItemRow(
    modifier: Modifier = Modifier,
    positionalThreshold: Float = 0.5f,
    delayDuration: Long = 300L,
    scope: CoroutineScope = rememberCoroutineScope(),
    itemVo: ItemVo,
    onClick: () -> Unit,
    onDelete: () -> Unit,
) {
    val dismissState = rememberSwipeToDismissBoxState(
        confirmValueChange = {
            when (it) {
                SwipeToDismissBoxValue.EndToStart -> {
                    scope.launch {
                        delay(delayDuration)
                        onDelete()
                    }
                }

                else -> return@rememberSwipeToDismissBoxState false
            }
            return@rememberSwipeToDismissBoxState true
        },
        positionalThreshold = { it * positionalThreshold }
    )
    SwipeToDismissBox(
        modifier = modifier,
        state = dismissState,
        enableDismissFromStartToEnd = false,
        backgroundContent = { DismissBackground() },
        content = {
            ItemRow(
                itemVo = itemVo,
                onClick = onClick
            )
        }
    )
}

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
            .background(MaterialTheme.colorScheme.background)
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
                text = String.format(
                    stringResource(id = R.string.double_percent_format),
                    itemVo.profit
                ),
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

@Composable
fun DismissBackground(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxSize()
            .background(Colors.Red)
            .padding(
                horizontal = AppTheme.dimensions.padding12,
                vertical = AppTheme.dimensions.padding8
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            imageVector = Icons.Default.Delete,
            contentDescription = "delete"
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