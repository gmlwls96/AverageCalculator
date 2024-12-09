package com.hj.average.feature.common.string

fun filterNumericAndDot(input: String): String {
    return input.filter { it.isDigit() || it == '.' }
}