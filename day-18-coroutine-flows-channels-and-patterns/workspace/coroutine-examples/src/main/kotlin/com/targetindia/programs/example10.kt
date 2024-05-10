package com.targetindia.programs

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf

fun main() {
    runBlocking {

        val ch = Channel<Int>()

        val j1 = launch {
            println("this is job1, trying to calculate the sum... <<${Thread.currentThread().name}>>")
            val data = sequenceOf(20, 40, 50)
            delay(2000)
            ch.send(data.sum()) // publish to the channel
            println("sum was published to the channel <<${Thread.currentThread().name}>>")
        }

        val j2 = launch {
            println("this is job2, want to get the sum <<${Thread.currentThread().name}>>")
            val data = ch.receive()
            println("got the sum as $data <<${Thread.currentThread().name}>>")
        }

        flowOf(j1, j2).collect { it.join() }
        ch.close() // close the channel only after all coroutines have finished their work
    }
}