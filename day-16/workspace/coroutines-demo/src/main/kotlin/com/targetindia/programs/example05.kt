package com.targetindia.programs


fun action(index: Int): Unit {
    println("index is $index")
}

fun main() {
    repeat(5) {
        println("hello, world!")
    }
    println()
    repeat(5) { index -> action(index) }
    println()
    repeat(5) { action(it) }
}