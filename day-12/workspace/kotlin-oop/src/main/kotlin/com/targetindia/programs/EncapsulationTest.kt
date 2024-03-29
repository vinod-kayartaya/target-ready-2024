package com.targetindia.programs

import com.targetindia.model.Product

fun main() {
    val p1 = Product()
    p1.id = 1291 // call to the setId(-1291)
    p1.name = "Apple Macbook Pro"
    p1.price = 129000.0

    println("p1 is $p1")

    val p2 = Product(992, "Apple Magic Pencil", 8500.0)
    println("p2 is $p2")

    val p3 = Product(8373, "Mi Note 7")
    p3.price = 12500.0
    println("p3 is $p3")

}