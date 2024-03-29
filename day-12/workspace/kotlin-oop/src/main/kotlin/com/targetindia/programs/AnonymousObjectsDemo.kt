package com.targetindia.programs

object Greet {
    fun sayHello() {
        println("Hello, world!")
    }
}

fun main() {

    println("p1 is an object of type ${Greet.javaClass.name}")
    Greet.sayHello()
}