package com.targetindia.programs

import com.targetindia.model.Square


class Circle {
    private var radius = 0.0

    constructor()
    constructor(radius: Double) {
        this.radius = radius
    }


    // not mentioning any access modifier makes this method as `public`
    fun printInfo() {
        println("radius = $radius units")
        println("area   = ${kotlin.math.PI * radius * radius} sq.units")
    }
}

fun main() {
    val c1 = Circle(12.34)
    // c1.radius = 12.34;
    c1.printInfo()

    val s1 = Square()
    s1.side = 12.34
    s1.printInfo()
}