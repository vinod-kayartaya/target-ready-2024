package com.targetindia.programs

import kotlinx.coroutines.*

fun main() {
    println("start of main() --> ${threadName()}")

    GlobalScope.launch {
        println("coroutine started --> ${threadName()}")
        delay(2000)
        println("coroutine ended --> ${threadName()}")
    }

    println("new coroutine launched --> ${threadName()}")
    Thread.sleep(2500)
    println("end of main() --> ${threadName()}")

}