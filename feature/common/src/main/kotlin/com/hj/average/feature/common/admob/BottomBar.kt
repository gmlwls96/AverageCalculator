package com.hj.average.feature.common.admob

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.hj.average.core.res.R
import com.hj.average.ui.component.BuildConfig
import com.hj.average.ui.component.admob.BannersAds

@Composable
fun AdsBottomBar(
    modifier: Modifier = Modifier,
) {
    BannersAds(
        modifier = modifier,
        unitId = stringResource(
            if (BuildConfig.DEBUG) {
                R.string.banner_ad_test_id
            } else {
                R.string.banner_ad_unit_id
            }
        )
    )
}