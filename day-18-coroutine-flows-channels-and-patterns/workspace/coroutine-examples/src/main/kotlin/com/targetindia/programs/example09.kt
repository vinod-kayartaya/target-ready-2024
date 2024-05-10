package com.targetindia.programs

import kotlinx.coroutines.flow.*

suspend fun main() {

    val f1 = flow<Int> {
        for (n in sequenceOf(10, 20, 1, 59, 0, 9, 19, 73)) {
            emit(n)
        }
    }

    f1
        .filter { it != 0 }
        .map { 1234 / it }
        .collect { println(it) }
}