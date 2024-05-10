package com.targetindia.programs

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

suspend fun table(n:Int, d:Long = 1000){
    for(i in 1..5){
        println("$n X $i = ${n*i}  <<running in thread -> ${Thread.currentThread().name}>>")
        delay(d) // suspending function; suspends itself, while other suspending functions can continue to execute
        // in the current thread
        //Thread.sleep(2000) // blocking function (blocks the rest of the code in the current thread
    }
}

fun main() {
    println("main() is running in thread -> ${Thread.currentThread().name}")
    runBlocking {
        launch { table(5, 1200) }
        launch { table(99, 400) }
        launch { table(78, 500) }
    }
}