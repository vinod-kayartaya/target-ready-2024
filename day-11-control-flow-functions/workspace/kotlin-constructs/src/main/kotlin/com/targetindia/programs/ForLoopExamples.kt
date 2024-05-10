package com.targetindia.programs

fun loopOverRange() {
    print("enter a number: ")
    val num = readln().toInt()

    // for(i in 1..10){
    val range = 1..15
    for (i in range) {
        println("$num X $i = ${num * i}")
        if (i == 10) break
    }

    for (i in range) {
        println(i)
    }
}

fun loopOverArrays() {
    val numbers = arrayOf<Int>(12, 39, 123, 58, 399, 48)
    println(numbers)
    for (n in numbers) {
        println("$n is of type ${n.javaClass.name}")
    }

    val rng = 1..2
    println(rng.javaClass.name) // kotlin.ranges.IntRange
}

fun loopOverList() {
    val names = listOf<String>("Vinod", "Murali", "Venu", "Shyam")
    println("names is an object of type ${names.javaClass.name}")
    for (name in names) {
        println("hello, $name")
    }
}

fun loopUsingIndex() {
    val numbers = arrayOf<Int>(12, 39, 123, 58, 399, 48)
    for (index in numbers.indices) { // index in 0..5
        println("value at index $index in numbers array is ${numbers[index]}")
        // println("value at index $index in numbers array is ${numbers.get(index)}")
    }

    val names = listOf<String>("Vinod", "Murali", "Venu", "Shyam")
    for (index in names.indices) {
        println("value at index $index in names list is ${names[index]}")
        // println("value at index $index in names list is ${names.get(index)}")
    }
}


fun loopOverMap() {
    val person = mapOf("name" to "Vinod", "age" to 50, "email" to "vinod@vinod.co")
    for ((k, v) in person) {
        println("$k --> $v")
    }
}

fun loopOverMapKeys() {
    val person = mapOf("name" to "Vinod", "age" to 50, "email" to "vinod@vinod.co")
    for (key in person.keys) {
        println("$key --> ${person[key]}")
        // println("$key --> ${person.get(key)}")
    }
}

fun main() {
    outer_loop@
    for (i in 5..10) {
        inner_loop@
        for (j in 10 downTo 5) {
            println("i is $i and j is $j")
            if (i == j) continue@outer_loop
        }
    }
}
