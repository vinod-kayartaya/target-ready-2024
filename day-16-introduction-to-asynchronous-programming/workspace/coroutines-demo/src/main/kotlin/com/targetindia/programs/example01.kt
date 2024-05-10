package com.targetindia.programs

// synchronous execution
fun main1() {
    printTable(12)
    printTable(98)
    printTable(45)
}

fun printTable(n: Int) {
    repeat(5) { index -> println("$n X ${index + 1} = ${n * (index + 1)} (thread name is ${Thread.currentThread().name}")}
}
