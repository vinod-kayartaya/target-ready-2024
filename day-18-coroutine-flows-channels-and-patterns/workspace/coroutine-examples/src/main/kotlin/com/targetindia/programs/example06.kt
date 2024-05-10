package com.targetindia.programs

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

suspend fun main() {
    println("start of main() <<${Thread.currentThread().name}>>")
    GlobalScope.launch {
        val f = flow {
            println("started the flow of numbers from 1 to 5 <<${Thread.currentThread().name}>>")
            for (i in 1..5) {
                delay(1000)
                emit(i)
            }
        }
        println("created cold stream <<${Thread.currentThread().name}>>")
        f.collect {
            println("$it <<${Thread.currentThread().name}>>")
        }
    }.join()

    println("end of main() <<${Thread.currentThread().name}>>")
}