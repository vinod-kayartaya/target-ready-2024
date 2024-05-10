package com.targetindia.programs

data class Flight(var from: String, var to: String)

fun main() {
    val f1 = Flight("BLR", "DLH")
    val f2 = Flight("BLR", "DLH")

    f2.from = "CHN"

    println("f1 is $f1")
    println("f2 is $f2")
    println("f1==f2 is ${f1 == f2}")
    println("f1.equals(f2) is ${f1.equals(f2)}") // Replace "equals" with binary operator "==".

}