package com.targetindia.prgrams

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    println("starting a new coroutine block...")

    runBlocking {
        println("coroutine block started")

        launch {
            println("coroutine-1 started")
            delay(1000)
            println("coroutine-1 ended")
        }
        launch {
            println("coroutine-2 started")
            delay(500)
            println("coroutine-2 ended")
        }

        println("launched 2 coroutines")
    }

    println("back to main() from the coroutine block.")
}