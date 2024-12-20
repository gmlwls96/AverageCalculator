package com.hj.average.feature.item.list.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.hj.average.core.res.R

@Composable
internal fun EmptyScreen(
    modifier: Modifier = Modifier,
) {
    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(R.raw.empty_content)
    )
    val progress by animateLottieCompositionAsState(composition)
    LottieAnimation(
        modifier = modifier.fillMaxSize(),
        composition = composition,
        progress = { progress },
    )
}