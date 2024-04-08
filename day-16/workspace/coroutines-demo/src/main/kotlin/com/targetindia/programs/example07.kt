package com.targetindia.programs

import kotlinx.coroutines.*

fun threadName(): String {
    return Thread.currentThread().name
}

suspend fun fun1() = coroutineScope {
    launch {
        println("start of coroutine-1 :: ${threadName()}")
        delay(3000)
        println("end of coroutine-1 :: ${threadName()}")
    }
    launch {
        println("start of coroutine-2 :: ${threadName()}")
        delay(2000)
        println("end of coroutine-2 :: ${threadName()}")
    }

    println("outside of any coroutines :: ${threadName()}")
}

fun main() = runBlocking {
    fun1()
    println("end of main().runBlocking{} :: ${threadName()}")
}