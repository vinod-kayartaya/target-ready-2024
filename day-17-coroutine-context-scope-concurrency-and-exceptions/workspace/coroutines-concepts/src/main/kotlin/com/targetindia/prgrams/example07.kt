package com.targetindia.prgrams

import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

// how do we deal with two or more coroutines competing for accessing/mutating a share resource

fun main1() {
    var num = 0

    runBlocking {

        val j1 = launch {
            num++
            delay(500) // simulation of some kind of IO or Network calls
            println("value of num in job 1 is $num")
        }

        val j2 = launch {
            num+=5
            delay(250)
            println("value of num in job 2 is $num")
        }

        j1.join()
        j2.join()
    }
}

// solution: Use Mutex

fun main() {
    var num = 0
    val mx = Mutex()

    runBlocking {

        val j1 = launch {
            mx.withLock {
                num++
                delay(2500) // simulation of some kind of IO or Network calls
                println("value of num in job 1 is $num (thread: ${Thread.currentThread().name})")
            }

        }

        val j2 = launch {
            mx.withLock {
                num+=5
                delay(0)
                println("value of num in job 2 is $num (thread: ${Thread.currentThread().name})")
            }
        }

        j1.join()
        j2.join()
    }
}