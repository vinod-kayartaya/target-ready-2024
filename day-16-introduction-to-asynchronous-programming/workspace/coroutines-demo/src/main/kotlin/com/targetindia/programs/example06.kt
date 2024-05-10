package com.targetindia.programs

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    greet()
}

suspend fun greet() {
    coroutineScope {
        launch {
            delay(1000)
            println("hello")
        }
        println("hi")
    }
    println("welcome")
}