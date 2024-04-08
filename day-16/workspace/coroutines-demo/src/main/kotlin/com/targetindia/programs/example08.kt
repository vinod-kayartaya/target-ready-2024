package com.targetindia.programs

import kotlinx.coroutines.*

fun main() = runBlocking {
    val theJob = launch {
        println("Start of the job...")
        delay(5000)
        println("the job is done!")
    }

    theJob.join() // wait until the child coroutine finishes
    println("end of main()")
}