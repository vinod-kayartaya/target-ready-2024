package com.targetindia.programs

fun main() {
    println("start of main()")

    try {
        print("enter numerator: ")
        val num = readln().toInt()
        print("enter denominator: ")
        val den = readln().toInt()

        val q = num / den
        val r = num % den
        println("$num / $den = $q")
        println("$num % $den = $r")

    } catch (e: NumberFormatException) {
        println("only integers were expected!")
    } catch (e: ArithmeticException) {
        println("cannot divide an integer by zero")
    }

    println("end of main()")
}