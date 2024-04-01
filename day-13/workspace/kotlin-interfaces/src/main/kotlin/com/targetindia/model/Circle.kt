package com.targetindia.model

class Circle : IGeometricShape {

    var x: Double = 0.0
    var y: Double = 0.0
    var radius: Double = 0.0

    constructor()

    constructor(radius: Double) {
        this.radius = radius
    }

    override fun getName(): String {
        return "Circle";
    }

    override fun getArea(): Double {
        return kotlin.math.PI * radius * radius
    }
}