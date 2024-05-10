package com.targetindia.prgrams

import kotlinx.coroutines.*

fun main() {
    runBlocking {
        val j1 = launch {
            repeat(10) {
                println("---- job 1 repeating itself ($it of 10) in the thread ${Thread.currentThread().name}")
                delay(100)
            }
        }
        val j2 = launch {
            repeat(10) {
                println(">>>> job 2 repeating itself ($it of 10) in the thread ${Thread.currentThread().name}")
                delay(100)
            }
        }

        j1.join()
        j2.join()
    }
}