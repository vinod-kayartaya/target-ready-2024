package com.targetindia

data class Person(val name: String, val age: Int)

sealed class Result
data class Success(val value: Int) : Result()
data class Error(val message: String) : Result()

fun getResultValue(result: Result): Int {
    return when (result) {
        is Success -> result.value
        is Error -> throw IllegalArgumentException(result.message)
    }
}