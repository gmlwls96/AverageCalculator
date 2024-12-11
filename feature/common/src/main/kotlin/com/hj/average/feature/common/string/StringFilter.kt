package com.hj.average.feature.common.string

import java.text.DecimalFormat

fun filterNumericAndDot(input: String): String {
    return input.filter { it.isDigit() || it == '.' }
}

@Suppress("TooGenericExceptionCaught")
val thousandsCommaString: (String) -> String = {
    try {
        DecimalFormat("#,###").format(it.toDouble())
    } catch (e: Exception) {
        it
    }
}

@Suppress("TooGenericExceptionCaught")
val percentString: (String) -> String = {
    try {
        DecimalFormat("#,###.###").format(it.toDouble()) + "%"
    } catch (e: Exception) {
        it
    }
}