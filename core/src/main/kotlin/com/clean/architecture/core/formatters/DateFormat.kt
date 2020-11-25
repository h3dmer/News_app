package com.clean.architecture.core.formatters

import java.text.SimpleDateFormat
import java.util.*

object DateFormat {

    fun convertDateToPattern(dateToConvert: String?, pattern: String): String {
        val parser = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ROOT)
        val formatter = SimpleDateFormat(pattern, Locale.ROOT)
        formatter.timeZone = TimeZone.getTimeZone("GMT")
        return formatter.format(parser.parse(dateToConvert))
    }
}