package com.targetindia.programs


import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main() {
    println("start of main() <<${Thread.currentThread().name}>>")
    runBlocking {
        val f = flow {
            println("started the flow of numbers from 1 to 5 <<${Thread.currentThread().name}>>")
            for(i in 1..5){
                delay(1000)
                emit(i)
            }
        }

        println("created cold stream <<${Thread.currentThread().name}>>")
        f.collect{
            println("$it <<${Thread.currentThread().name}>>")
        }
        println("the cold stream has ${f.count()} elements")
    }
    println("end of main() <<${Thread.currentThread().name}>>")

}