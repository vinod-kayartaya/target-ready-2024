package com.targetindia.programs

fun main() {
    println("start of main()")

    val num: Int
    val den = try {
        print("enter numerator: ")
        num = readln().toInt()
        print("enter denominator: ")
        readln().toInt()
    } catch (e: Exception) {
        println("only integers were expected!")
        return // exit early
    }

    try {
        val q = num / den
        val r = num % den
        println("$num / $den = $q")
        println("$num % $den = $r")
    } catch (e: ArithmeticException) {
        println("cannot divide an integer by zero")
    }

    println("end of main()")
}