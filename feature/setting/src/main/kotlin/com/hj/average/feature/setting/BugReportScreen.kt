package com.hj.average.feature.setting

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.hj.average.feature.setting.components.BugReportHeader
import com.hj.average.core.res.R
import com.hj.average.ui.component.core.SpacerHeight
import com.hj.average.ui.theme.AppTheme
import com.hj.average.ui.theme.AveTheme
import com.hj.average.ui.theme.Colors

@Composable
fun BugReportScreen(
    modifier: Modifier = Modifier,
    onBack: () -> Unit,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            BugReportHeader(onBack = onBack)
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .padding(horizontal = AppTheme.dimensions.padding20),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                modifier = Modifier.size(AppTheme.dimensions.width105),
                painter = painterResource(id = R.drawable.ic_stop),
                contentDescription = null,
                tint = Colors.Red
            )
            SpacerHeight(dp = AppTheme.dimensions.padding30)
            Text(
                text = stringResource(id = R.string.setting_bug_report_content),
                style = AppTheme.typography.noto16,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onPrimary
            )
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

@Preview
@Composable
private fun BugReportScreenPreview() {
    AveTheme(isDarkTheme = false) {
        BugReportScreen(
            onBack = {}
        )
    }
}