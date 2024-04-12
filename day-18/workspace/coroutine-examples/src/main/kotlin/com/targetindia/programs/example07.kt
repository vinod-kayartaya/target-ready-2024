package com.targetindia.programs

import kotlinx.coroutines.flow.*
import java.util.stream.Stream

suspend fun main() {

    flowOf("vinod", "shyam", "bangalore", "india", "day", "night")
        .collect { println(it) } // .collect is a suspending function,


    println(".".repeat(50))


    Stream.of("vinod", "shyam", "bangalore", "india", "day", "night")
        .forEach { println(it) } // synchronous function

    println(".".repeat(50))

    (1..5).asFlow()
        .collect { println(it) }

    println(".".repeat(50))

    (1..15).asFlow()
        .filter { it % 2 == 0 }
        .map { it * 2 }
        .collect { println(it) }
    println(".".repeat(50))

    val s1 = sequenceOf("vinod", "shyam", "harish")
    val s2 = flowOf("vinod@vinod.co", "shyam@xmpl.com", "harish@maill.com")

    s1.asFlow()
        .zip(s2) { name, email -> "$name's email is $email" }
        .collect { println(it) }
}