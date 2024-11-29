package com.hj.average.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

data class AppTypography(
    val noto32: TextStyle = TextStyle(
        fontWeight = FontWeight.W700,
        fontSize = 32.sp,
        textAlign = TextAlign.Center,
        color = Colors.Gray1000,
    ),

    val noto28: TextStyle = noto32.copy(fontSize = 28.sp),
    val noto26: TextStyle = noto32.copy(fontSize = 26.sp),
    val noto24: TextStyle = noto32.copy(fontSize = 24.sp),
    val noto22: TextStyle = noto32.copy(fontSize = 22.sp),
    val noto20: TextStyle = noto32.copy(fontSize = 20.sp),
    val noto20Regular: TextStyle = TextStyle(
        fontWeight = FontWeight.W400,
        fontSize = 20.sp,
        textAlign = TextAlign.Center,
        color = Colors.Gray800
    ),
    val noto18: TextStyle = noto32.copy(fontSize = 18.sp),
    val noto18Regular: TextStyle = TextStyle(
        fontWeight = FontWeight.W400,
        fontSize = 18.sp,
        textAlign = TextAlign.Center,
        color = Colors.Gray900
    ),
    val noto16: TextStyle = noto32.copy(fontSize = 16.sp),
    val noto16Medium: TextStyle = TextStyle(
        fontWeight = FontWeight.W500,
        fontSize = 16.sp,
        textAlign = TextAlign.Center,
        color = Colors.Gray1000
    ),

    val noto16Regular: TextStyle = TextStyle(
        fontWeight = FontWeight.W400,
        fontSize = 16.sp,
        textAlign = TextAlign.Center,
        color = Colors.Gray800
    ),

    val noto15: TextStyle = noto32.copy(fontSize = 15.sp),
    val noto15Medium: TextStyle = TextStyle(
        fontWeight = FontWeight.W500,
        fontSize = 15.sp,
        textAlign = TextAlign.Center,
        color = Colors.Gray1000
    ),

    val noto15Regular: TextStyle = TextStyle(
        fontWeight = FontWeight.W400,
        fontSize = 15.sp,
        textAlign = TextAlign.Center,
        color = Colors.Gray200
    ),

    val noto14: TextStyle = noto32.copy(fontSize = 14.sp),
    val noto14Medium: TextStyle = TextStyle(
        fontWeight = FontWeight.W500,
        fontSize = 14.sp,
        textAlign = TextAlign.Center,
        color = Colors.Gray1000
    ),
    val noto14Regular: TextStyle = TextStyle(
        fontWeight = FontWeight.W400,
        fontSize = 14.sp,
        textAlign = TextAlign.Center,
        color = Colors.Gray800
    ),

    val noto13: TextStyle = noto32.copy(fontSize = 13.sp),
    val noto13Medium: TextStyle = TextStyle(
        fontWeight = FontWeight.W500,
        fontSize = 13.sp,
        textAlign = TextAlign.Center,
        color = Colors.Gray800
    ),
    val noto13Regular: TextStyle = TextStyle(
        fontWeight = FontWeight.W400,
        fontSize = 13.sp,
        textAlign = TextAlign.Center,
        color = Colors.Gray1000
    ),

    val noto12: TextStyle = noto32.copy(fontSize = 12.sp),
    val noto12Medium: TextStyle = TextStyle(
        fontWeight = FontWeight.W500,
        fontSize = 12.sp,
        textAlign = TextAlign.Center,
        color = Colors.Gray700
    ),
    val noto12Regular: TextStyle = TextStyle(
        fontWeight = FontWeight.W400,
        fontSize = 12.sp,
        textAlign = TextAlign.Center,
        color = Colors.Gray700
    ),

    val noto11: TextStyle = noto32.copy(fontSize = 11.sp),
    val noto11Regular: TextStyle = noto32.copy(fontSize = 11.sp, fontWeight = FontWeight.W400),
    val noto10: TextStyle = noto32.copy(fontSize = 10.sp, fontWeight = FontWeight.W500),

    val roboto28: TextStyle = TextStyle(
        fontWeight = FontWeight.W700,
        fontSize = 28.sp,
        textAlign = TextAlign.Center,
        color = Colors.Black
    ),

    val roboto26: TextStyle = roboto28.copy(fontSize = 26.sp),
    val roboto24: TextStyle = roboto28.copy(fontSize = 24.sp),
    val roboto22: TextStyle = roboto28.copy(fontSize = 22.sp),
    val roboto18: TextStyle = roboto28.copy(fontSize = 18.sp),
    val roboto16: TextStyle = roboto28.copy(fontSize = 16.sp),
    val roboto15: TextStyle = roboto28.copy(fontSize = 15.sp),
    val roboto14: TextStyle = roboto28.copy(fontSize = 14.sp),
    val roboto11: TextStyle = roboto28.copy(fontSize = 11.sp),

    val googleLoginBt: TextStyle = noto16.copy(color = Colors.Gray800),
    val bottomBt: TextStyle = noto16.copy(color = Colors.White),
    val customTextField: TextStyle = noto20.copy(
        fontWeight = FontWeight.W400,
        textAlign = TextAlign.Start
    )
)

internal val LocalTypography = staticCompositionLocalOf { AppTypography() }