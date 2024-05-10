package com.targetindia.prgrams

import kotlinx.coroutines.*

fun main() {

    runBlocking {
        val job1 = launch {
            repeat(25) { i->
                try {
                    println("JOB1: I am sleeping $i...")
                    delay(500)
                } catch (e: Exception) {
                    println("($i) got an exception of type ${e.javaClass.name}")
                }
            }
        }
        val job2 = launch {
            repeat(25) { i->
                println("JBO2: I am sleeping $i...")
                delay(500)
            }
        }

        repeat(10) {i->
            println("repeating some task 10 times.. ($i)")
            delay(250)
        }

        println("i don't want to wait for the job to be completed anymore...")
        // j.cancel() // cancelling the job
        // j.join() // waiting for the cancelled job to be shutdown properly
        job1.cancelAndJoin() // cancels and continues to execute the next statement
        job2.join() // waits for the job2 to complete gracefully

        println("the end")
    }
}