package com.targetindia.programs

import com.targetindia.model.Customer

fun main() {
    val c1 = Customer("Vinod", "Bangalore", "vinod@vinod.co")
    println(c1.getAsJson())
    println(c1.getAsCsv())
    c1.print()

    val c2 = Customer("Vinay", email = "vinay@xmpl.com")
    println(c2.getAsJson())
    c2.print()
}