package com.targetindia.model

class Square {
    internal var side: Double = 0.0

    constructor()
    constructor(side: Double) {
        this.side = side
    }


    fun printInfo() {
        println("side   = $side units")
        println("area   = ${side * side} sq.units")
    }

}