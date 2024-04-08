package com.targetindia.programs

import kotlinx.coroutines.*


fun main() {
    println("start of main()")
    runBlocking {
        launch {
            delay(3000)
            println("World!")
        } // non blocking code
        println("Hello")
    } // blocking code
    println("end of main()")
}