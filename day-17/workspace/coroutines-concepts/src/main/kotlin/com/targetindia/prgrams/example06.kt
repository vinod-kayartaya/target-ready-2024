package com.targetindia.prgrams

import kotlinx.coroutines.delay
import kotlinx.coroutines.job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val jobs = List(10) {
            launch {
                println("job ${it + 1} started in the thread ${Thread.currentThread().name}")
                repeat(10) { i ->
                    delay(1)
                    println("job ${it+1} counter is $i in the thread ${Thread.currentThread().name}")
                }
                println("job ${it + 1} completed in the thread ${Thread.currentThread().name}")
            }
        }

        jobs.forEach { it.join() }
    }
}