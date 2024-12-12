package com.hj.average.ui.component.admob

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.viewinterop.AndroidView
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.hj.average.ui.component.core.SpacerHeight
import com.hj.average.ui.theme.AppTheme
import com.hj.average.ui.theme.Colors
import com.hj.average.core.res.R

@Suppress("LongMethod")
@Composable
fun BannersAds(
    modifier: Modifier = Modifier,
    paddingTop: Dp = AppTheme.dimensions.padding20,
    density: Density = LocalDensity.current,
    height: Dp = AppTheme.dimensions.height56,
    unitId: String,
) {
    var width by remember {
        mutableIntStateOf(0)
    }
    var loadingState by remember {
        mutableStateOf(true)
    }

    Column {
        SpacerHeight(dp = paddingTop)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(height)
                .clip(shape = RoundedCornerShape(AppTheme.dimensions.radius12))
                .background(color = Colors.Gray400)
                .onSizeChanged {
                    width = it.width
                }
        ) {
            if (width > 0) {
                val heightPx = with(density) { height.toPx() }
                AndroidView(
                    modifier = modifier.fillMaxWidth(),
                    factory = { context ->
                        AdView(context).apply {
                            setAdSize(
                                AdSize.getInlineAdaptiveBannerAdSize(
                                    (width / density.density).toInt(),
                                    (heightPx / density.density).toInt()
                                )
                            )
                            adUnitId = unitId
                            loadingState = true
                            loadAd(AdRequest.Builder().build())
                            adListener = object : AdListener() {
                                override fun onAdLoaded() {
                                    super.onAdLoaded()
                                    loadingState = false
                                }
                            }
                        }
                    },
                    update = { adView ->
                        loadingState = true
                        adView.loadAd(AdRequest.Builder().build())
                    }
                )
            }
            if (loadingState) {
                val composition by rememberLottieComposition(
                    LottieCompositionSpec.RawRes(R.raw.loading)
                )
                val progress by animateLottieCompositionAsState(composition)
                LottieAnimation(
                    modifier = Modifier.fillMaxSize(),
                    composition = composition,
                    progress = { progress },
                )
            }
        }
    }
}