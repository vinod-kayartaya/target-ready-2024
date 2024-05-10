package com.targetindia.prgrams

import kotlinx.coroutines.*

fun main() {
    println("start of main()")
    GlobalScope.launch {
        repeat(50) { i ->
            println("repeating $i of 50 times inside a coroutine on the thread ${Thread.currentThread().isDaemon}...")
            delay(250)
        }
    }

    Thread.sleep(2000);
    println("end of main()")
}