package com.targetindia.programs

abstract class Shape {
    abstract fun shapeName():String
    abstract fun formula():String

    open fun area(): Double {
        return 0.0
    }
}

class Triangle(var base: Double = 0.0, var height: Double = 0.0) : Shape() {
    override fun shapeName(): String {
        return "Triangle"
    }

    override fun formula(): String {
        return "0.5 * base * height"
    }

    override fun area(): Double {
        return 0.5 * base * height
    }
}

open class Rectangle(var length: Double = 0.0, var breadth: Double = 0.0) : Shape() {
    override fun shapeName(): String {
        return "Rectangle"
    }

    override fun formula(): String {
        return "length * breadth"
    }

    override fun area(): Double {
        return length * breadth
    }
}

class Square(var side: Double = 0.0) : Rectangle(side, side){
    override fun shapeName(): String {
        return "Square"
    }

    override fun formula(): String {
        return "side * side"
    }
}

// polymorphic method; works with an object of Shape, not knowing what is the actual instance type
fun printShapeDetails(shape: Shape) {
    println("shape is an object of ${shape.shapeName()} type and its area is ${shape.area()} (using the formula ${shape.formula()})")
}


fun main() {
    // val s1 = Shape()
    val s2 = Triangle(12.34, 56.78)
    val s3 = Square(43.21)
    val s4 = Rectangle(1.2, 3.4)

    // printShapeDetails(s1)
    printShapeDetails(s2)
    printShapeDetails(s3)
    printShapeDetails(s4)
}