package com.targetindia.programs

fun cube(num: Double): Double {
    return num*num*num
}

fun main(){
    print("enter a number: ")
    val num = readln().toDouble()
    val c = cube(num)
    println("cube of $num is $c")
    val amountInr = 3000
    val amountUsd = amountInr / 83.41
    println("Rs.$amountInr is \$$amountUsd")
}