package com.targetindia.programs

fun main() {

    var num: Byte = -128
    println("value of num is $num")
    var num2: Float = 2.2F
    var num3: Double = 3.3

    val n1 = 122
    val n2 = 20
    println("$n1 < $n2 is ${n1 < n2}")

    // val n3 = n1 < n2 ? 100: 200
    val n3 = if (n1 < n2) 100 else 200
    // python: n3 = 100 if n1 < n2 else 200

}