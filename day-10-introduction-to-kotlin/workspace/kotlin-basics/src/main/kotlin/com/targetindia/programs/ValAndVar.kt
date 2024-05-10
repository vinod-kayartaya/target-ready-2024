package com.targetindia.programs

fun input(message: String): String {
    print(message)
    return readln()
}

fun main(){
    // this is a single line comment
    /*
    this is a multiline comment
    */
    var num = input("enter a number: ").toInt()
    num++ // not possible if `num` were a `val`
    println("value of num is $num")
}