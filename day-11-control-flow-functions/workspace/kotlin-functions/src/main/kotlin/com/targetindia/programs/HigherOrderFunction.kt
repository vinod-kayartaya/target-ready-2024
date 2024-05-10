package com.targetindia.programs

// this function has 3 parameters
// 1st --> Int
// 2nd --> Int
// 3rd --> function that takes 2 Int parameters and returns an Int
fun doMathOperation(num1: Int, num2: Int, operation: (Int, Int) -> Int): Int {
    return operation(num1, num2)
}

fun add(n: Int, m: Int): Int {
    return n + m
}

fun subtract(n: Int, m: Int): Int = n - m

val multiply: (Int, Int) -> Int = { a, b -> a * b }

fun main() {
    print("enter number 1: ")
    val x = readln().toInt()
    print("enter number 2: ")
    val y = readln().toInt()

    val sum = doMathOperation(x, y, ::add) // i am not calling add, but doMathOperation will call
    val diff = doMathOperation(x, y) { x, y -> subtract(x, y) }
    val prod = doMathOperation(x, y, multiply) // named lambda expression
    val quot = doMathOperation(x, y) { x, y -> x / y } // anonymous lambda expression
    val rem = doMathOperation(x, y, { x, y -> x % y })

    println("sum of $x and $y is $sum")
    println("difference of $x and $y is $diff")
    println("product of $x and $y is $prod")
    println("quotient of $x / $y is $quot")
    println("remainder of $x / $y is $rem")
}