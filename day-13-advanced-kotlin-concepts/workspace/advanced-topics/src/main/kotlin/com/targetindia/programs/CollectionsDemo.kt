package com.targetindia.programs

fun main() {
    val nums = listOf<Int>(12, 34, 56, 78)
    val squares = nums.map { it * it }

    println(nums)
    println(squares)

    val names = listOf<String>("vinod", "shyam", "murali", "vinay", "vishal", "naveen", "vijay")
    val namesStartingWithVi = names.filter { it.startsWith("vi") }

    println(names)
    println(namesStartingWithVi)
}