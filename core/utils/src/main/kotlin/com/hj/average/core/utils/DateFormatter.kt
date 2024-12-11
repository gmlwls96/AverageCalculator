package com.hj.average.core.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.time.DayOfWeek
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.ZoneId

object DateFormatter {
    @SuppressLint("SimpleDateFormat")
    fun getDateFormat(format: String = DATE_FORMAT) = SimpleDateFormat(format)

    fun convertMillisToMmSs(ms: Long, format: String = "%02d:%02d"): String {
        val seconds = ms / 1000
        val s = seconds % 60
        val m = seconds / 60 % 60
        return String.format(format, m, s)
    }

    fun convertMillisToHMS(ms: Long, format: String = "%02d:%02d:%02d"): String {
        val seconds = ms / 1000 // 밀리초를 초로 변환
        val hours = seconds / 3600
        val minutes = (seconds % 3600) / 60
        val remainingSeconds = seconds % 60

        return String.format(format, hours, minutes, remainingSeconds)
    }

    fun convertTimestampToKoreanDate(timestamp: Long): String {
        val dateTime = LocalDateTime.ofInstant(
            Instant.ofEpochMilli(timestamp),
            ZoneId.systemDefault()
        )
        val koreanDayOfWeek = arrayOf("일", "월", "화", "수", "목", "금", "토")
        val formatter = java.time.format.DateTimeFormatter.ofPattern("yyyy년 M월 d일")

        return "${dateTime.format(formatter)} ${koreanDayOfWeek[dateTime.dayOfWeek.value % DayOfWeek.entries.size]}요일"
    }

    fun convertTimestampToDate(
        timestamp: Long,
        format: String = "${YEAR}년 ${MONTH_1}월"
    ): String {
        val dateTime = LocalDateTime.ofInstant(
            Instant.ofEpochMilli(timestamp),
            ZoneId.systemDefault()
        )
        val formatter = java.time.format.DateTimeFormatter.ofPattern("yyyy년 M월")
        return dateTime.format(formatter)
    }

    fun convertTimestampToLocalDate(timestamp: Long): LocalDate {
        return Instant.ofEpochMilli(timestamp)
            .atZone(ZoneId.systemDefault())
            .toLocalDate()
    }

    fun LocalDate.toTimestamp(): Long {
        // LocalDate에 시간 정보 추가 (자정으로 설정)
        val localDateTime = this.atTime(LocalTime.MIDNIGHT)

        // 시스템 기본 시간대 사용
        val zonedDateTime = localDateTime.atZone(ZoneId.systemDefault())

        // Epoch 밀리초로 변환
        return zonedDateTime.toInstant().toEpochMilli()
    }

    const val YEAR = "yyyy"
    const val SHORT_YEAR = "yy"
    const val MONTH = "MM"
    const val MONTH_1 = "M"
    const val DAY = "dd"
    const val HOUR = "HH"
    const val MINUTE = "mm"
    const val SECOND = "ss"
    const val AM_PM = "aaa"

    const val DATE_FORMAT = "$YEAR.$MONTH.$DAY"
    const val TIME_FORMAT = "$HOUR:$MINUTE:$SECOND"
    const val DATE_TIME_FORMAT = "$DATE_FORMAT-$TIME_FORMAT"
    const val SHORT_DATA_FORMAT = "$SHORT_YEAR.$MONTH.$DAY"
}