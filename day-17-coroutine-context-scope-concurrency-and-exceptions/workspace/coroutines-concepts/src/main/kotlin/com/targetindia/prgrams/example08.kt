package com.targetindia.prgrams

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.sync.Semaphore

val semaphore = Semaphore(2)

suspend fun accessSharedResource(id: Int) {
    semaphore.acquire()
    println("Accessing resource $id")
    delay(1000)
    println("resource $id accessed")
    semaphore.release()
}

fun main() {
    runBlocking {
        repeat(5) { id ->
            launch {
                accessSharedResource(id + 1)
            }
        }
    }
}