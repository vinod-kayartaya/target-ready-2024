package com.targetindia.tests

import com.targetindia.Success
import com.targetindia.Error
import com.targetindia.getResultValue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class SealedClassTests {
    @Test
    fun `test sealed class`() {
        val successResult = Success(42)
        val errorResult = Error("Something went wrong")

        assertEquals(42, getResultValue(successResult))

        assertThrows<IllegalArgumentException> { getResultValue(errorResult) }
    }
}