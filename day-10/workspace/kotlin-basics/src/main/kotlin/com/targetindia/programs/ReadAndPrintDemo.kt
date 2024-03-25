package com.targetindia.programs
import kotlin.math.sqrt

fun main(){
    println("hello, there!")
    print("enter a number: ")
    val input = readln()
    val num = input.toDouble()
    val result = sqrt(num)
    System.out.printf("square root of %f is %f\n", num, result)
}