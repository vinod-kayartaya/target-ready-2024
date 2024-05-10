package com.targetindia.programs

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

suspend fun main() {
    val f1 = flow {
        val s1 = sequenceOf("vinod", "shyam", "harish")
        s1.forEach {
            delay((5000 + Math.random() * 2500).toLong())
            println("emitting $it from f1")
            emit(it)
        }
    }

    val f2 = flow {
        val s1 = sequenceOf("vinod@vinod.co", "shyam@xmpl.com", "harish@maill.com")
        s1.forEach {
            delay((1000 + Math.random() * 2500).toLong())
            println("emitting $it from f2")
            emit(it)
        }
    }

    f1.zip(f2) { name, email -> "$name's email is $email" }.collect { println(it) }
}