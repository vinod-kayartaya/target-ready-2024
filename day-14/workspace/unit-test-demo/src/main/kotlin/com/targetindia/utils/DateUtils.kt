package com.targetindia.utils

import com.targetindia.utils.exceptions.InvalidMonthException
import com.targetindia.utils.exceptions.InvalidYearException

fun maxDays(month: Int, year: Int): Int {
    if (month !in 1..12) {
        throw InvalidMonthException("month must be between 1 and 12")
    }

    if (year < 1) {
        throw InvalidYearException("year must be >= 1")
    }

    var days = 31
    when (month) {
        2 -> days = if (year % 400 == 0 || year % 4 == 0 && year % 100 != 0) 29 else 28
        4, 6, 9, 11 -> days = 30
    }
    return days
}