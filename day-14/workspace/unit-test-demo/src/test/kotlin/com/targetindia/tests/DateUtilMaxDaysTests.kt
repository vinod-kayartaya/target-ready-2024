package com.targetindia.tests

import com.targetindia.utils.exceptions.InvalidMonthException
import com.targetindia.utils.maxDays
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.*
import java.util.stream.Stream

class DateUtilMaxDaysTests {

    // static method
    companion object {
        @JvmStatic
        fun invalidMonthInputs(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(13),
                Arguments.of(-5),
                Arguments.of(17),
                Arguments.of(-200),
                Arguments.of(0),
            )
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [1992, 1996, 2000, 2004, 2020, 2024])
    @DisplayName("Maximum days for leap year february")
    fun testMaxDaysForLeapYearFebruary(year: Int) {
        val actual = maxDays(2, year)
        Assertions.assertEquals(29, actual)
    }

    @ParameterizedTest
    @ValueSource(ints = [2021, 2022, 2023, 2025, 2026, 2027])
    @DisplayName("Maximum days for non leap year february")
    fun testMaxDaysForNonLeapYearFebruary(year: Int) {
        val expected = 28
        val actual = maxDays(2, year)
        Assertions.assertEquals(expected, actual)
    }

    @ParameterizedTest
    @CsvFileSource(files = ["test-inputs.csv"])
    @DisplayName("Maximum days for shorter months")
    fun testMaxDaysForShorterMonths(month: Int, year: Int) {
        val expected = 30
        val actual = maxDays(month, year)
        Assertions.assertEquals(expected, actual)
    }

    @ParameterizedTest
    @CsvSource(value = ["1, 2023", "1, 2024", "3, 2000", "5, 1999", "8, 1990"])
    @DisplayName("Maximum days for longer months")
    fun testMaxDaysForLongerMonths(month: Int, year: Int) {
        val expected = 31
        val actual = maxDays(month, year)
        Assertions.assertEquals(expected, actual)
    }

    @ParameterizedTest
    @MethodSource(value = ["invalidMonthInputs"])
    @DisplayName("Invalid month supplied")
    fun testInvalidMonth(month: Int) {
        try {
            maxDays(month, 2024)
            // this wasn't supposed to continue; so, let's fail the test
            Assertions.fail("expected InvalidMonthException, but didn't get one")
        } catch (e: InvalidMonthException) {
            // this was expected to happen; so all is well
        }
    }
}
