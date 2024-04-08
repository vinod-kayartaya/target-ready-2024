package com.targetindia.programs

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    repeat(1_000_000){
        launch {
            delay(500)
            print(".")
        }
    }
}