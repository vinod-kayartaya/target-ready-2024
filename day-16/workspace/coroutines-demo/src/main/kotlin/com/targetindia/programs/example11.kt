package com.targetindia.programs

import kotlinx.coroutines.*

fun main() {
    println("start of main() --> ${threadName()}")
    val result = GlobalScope.async {
        // launches in a new thread
        println("start of a new async task (coroutine) --> ${threadName()}")
        delay(8000)
        "Hello, world!"
    }

    runBlocking {
        println("start of runBlocking{} --> ${threadName()}")
        launch {
            // uses the parent thread
            println("just launched a new coroutine... --> ${threadName()}")
        }
        val anotherResult = async {
            // uses the parent thread
            println("another coroutine is launched using async --> ${threadName()}")
            delay(4000);
            "coroutines are awesome!"
        }
        println("result is ${anotherResult.await()} --> ${threadName()}")
        println("result is ${result.await()} --> ${threadName()}")

    }// until this is over, do not go further. i.e, do not end main()
    println("end of main() --> ${threadName()}")
}