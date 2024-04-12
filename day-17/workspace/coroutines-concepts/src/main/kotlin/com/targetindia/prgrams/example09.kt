package com.targetindia.prgrams

import kotlinx.coroutines.*
import java.lang.RuntimeException

fun main() {
    println("start of main()")
    runBlocking {

        val exceptionHandler = CoroutineExceptionHandler { _, ex ->
            println("something went wrong - ${ex.message} in thread ${Thread.currentThread().name}")
        }

        println("start of coroutine scope")
        val job = GlobalScope.launch(exceptionHandler) {
            println("job 1 started in thread ${Thread.currentThread().name}")
            delay(1000) // simulation of a network call
            // imagine the network threw an exception, which is not handled here
            throw RuntimeException("network error") // simulation of a network failure
        }

        job.join()
        println("end of coroutine scope")
    }
    println("end of main()")
}