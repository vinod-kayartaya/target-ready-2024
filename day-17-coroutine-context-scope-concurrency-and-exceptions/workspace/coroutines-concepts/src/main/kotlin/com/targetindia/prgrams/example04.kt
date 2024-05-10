package com.targetindia.prgrams

import kotlinx.coroutines.*

fun main() {
    runBlocking {
        println("coroutineContext's name is ${coroutineContext[CoroutineName]}")
        println("running in the thread ${Thread.currentThread().name}");

        // create a new coroutine job using the default scope (CoroutineScope)
        var customContext = Dispatchers.Default + CoroutineName("myOwnCoroutineName") + Job()
        val job = this.launch(customContext) {
            println("job 1 - running in ${coroutineContext[CoroutineName]}")
        }

        val customScope = CoroutineScope(Dispatchers.IO + Job())
        val job2 = customScope.launch {
            println("job 2 - running in ${coroutineContext[Job]}")
            println("job 2 running in the thread ${Thread.currentThread().name}");
        }

        customContext = newSingleThreadContext("vin-thread-001")
        val job3 = launch(customContext) {
            println("job 3 running in the thread ${Thread.currentThread().name}");
        }

        job.join()
        job2.join()
        job3.join()

    }
}