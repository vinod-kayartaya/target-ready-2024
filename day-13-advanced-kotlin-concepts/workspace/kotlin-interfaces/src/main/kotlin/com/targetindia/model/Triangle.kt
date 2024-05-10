package com.targetindia.model

class Triangle : IGeometricShape, IMovable {
    var x: Double = 0.0
    var y: Double = 0.0
    var base: Double = 1.0
    var height: Double = 1.0

    constructor()

    constructor(base: Double, height: Double) {
        this.base = base
        this.height = height
    }

    override fun getName(): String {
        return "Triangle"
    }

    override fun getArea(): Double {
        return 0.5 * base * height
    }

    override fun moveLeft(by: Double) {
        x -= by
    }

    override fun moveRight(by: Double) {
        x += by
    }

    override fun moveUp(by: Double) {
        y -= by
    }

    override fun moveDown(by: Double) {
        y += by
    }
}