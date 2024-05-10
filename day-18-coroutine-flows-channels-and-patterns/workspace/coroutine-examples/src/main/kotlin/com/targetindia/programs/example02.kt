package com.targetindia.programs

import kotlinx.coroutines.*

fun main() {
    runBlocking {

        val job = launch {
            println("first job started (thread ${Thread.currentThread().name})")
            delay(500)
            println("first job is over (thread ${Thread.currentThread().name})")
        }

        delay(2000)
        job.cancel()

        val deferredMessage = async {
            println("this is the job#2 (thread ${Thread.currentThread().name})")
            delay(5000)
            // the last expression in this job is considered as the return value
            "Hello, world"
        }
        println("job#2 has been initiated (thread ${Thread.currentThread().name})")

        // delay(4000)
        // Thread.sleep(4000)
        val message = deferredMessage.await()
        println("message is $message (thread ${Thread.currentThread().name})")
        println("end of main() (thread ${Thread.currentThread().name})")
    }
}