package com.targetindia.programs


fun main() {
    print("enter a number: ")
    val n = readln().toInt()
    val f = factorial(n)
    val s = square(n)
    println("factorial of $n is $f")
    println("square of $n is $s")
}

fun factorial(num: Int): Int {
    if (num <= 1) return 1

    var f = 1
    for (i in 2..num) {
        f *= i
    }
    return f
}

// single-expression-function
fun square(num: Int): Int = num * num
