package com.hj.average.feature.common.input

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import java.math.BigDecimal
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale

private const val GROUPING_SYMBOL = ','
private const val DECIMAL_SYMBOL = '.'

private val numberFormatter: DecimalFormat = DecimalFormat("#,###").apply {
    decimalFormatSymbols = DecimalFormatSymbols(Locale.getDefault()).apply {
        groupingSeparator = GROUPING_SYMBOL
        decimalSeparator = DECIMAL_SYMBOL
    }
}

class DecimalAmountTransformation : VisualTransformation {

    override fun filter(text: AnnotatedString): TransformedText {
        val transformation = reformat(text.text)

        return TransformedText(
            AnnotatedString(transformation.formatted ?: ""),
            object : OffsetMapping {
                override fun originalToTransformed(offset: Int): Int {
                    return transformation.originalToTransformed[offset]
                }

                override fun transformedToOriginal(offset: Int): Int {
                    return transformation.transformedToOriginal[offset]
                }
            },
        )
    }

    @Suppress("MagicNumber")
    private fun reformat(original: String): Transformation {
        val parts = original.split(DECIMAL_SYMBOL)
        check(parts.size < 3) { "original text must have only one dot (use filteredDecimalText)" }

        val hasEndDot = original.endsWith('.')
        var formatted = original

        if (original.isNotEmpty() && parts.size == 1) {
            formatted = numberFormatter.format(BigDecimal(parts[0]))

            if (hasEndDot) {
                formatted += DECIMAL_SYMBOL
            }
        } else if (parts.size == 2) {
            val numberPart = numberFormatter.format(BigDecimal(parts[0]))
            val decimalPart = parts[1]

            formatted = "$numberPart.$decimalPart"
        }

        val originalToTransformed = mutableListOf<Int>()
        val transformedToOriginal = mutableListOf<Int>()
        var specialCharsCount = 0

        formatted.forEachIndexed { index, char ->
            if (GROUPING_SYMBOL == char) {
                specialCharsCount++
            } else {
                originalToTransformed.add(index)
            }
            transformedToOriginal.add(index - specialCharsCount)
        }
        originalToTransformed.add(originalToTransformed.maxOrNull()?.plus(1) ?: 0)
        transformedToOriginal.add(transformedToOriginal.maxOrNull()?.plus(1) ?: 0)

        return Transformation(formatted, originalToTransformed, transformedToOriginal)
    }
}

data class Transformation(
    val formatted: String?,
    val originalToTransformed: List<Int>,
    val transformedToOriginal: List<Int>,
)