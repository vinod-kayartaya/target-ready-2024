package com.targetindia.programs

fun main() {
    val numbers = mutableListOf<Int>(29, 49, 29, 49, 299, 29, 49, 299, 48, 223, 48)

    // forEach
    println("numbers.forEach { println(it) }")
    numbers.forEach { print("$it, ") }
    println()
    println("numbers.forEach { n -> println(n) }")
    numbers.forEach { n -> print("$n, ") }
    println()

    val tenPercents = numbers.map { it / 10.0 } // numbers.map { n -> n/10.0 }
    println("numbers.map { it / 10.0 }: ")
    println(tenPercents)

    val oddNumbers = numbers.filter { it % 2 == 1 } // numbers.filter { x -> x%2==1 }
    println("numbers.filter { it % 2 == 1 }")
    println(oddNumbers)

    val nums = listOf(19, 29, 39)
    val additionNumbers = oddNumbers.plus(nums)
    println(additionNumbers)
}