package com.targetindia.work

import com.targetindia.model.Person

fun main() {
    val p1 = Person()
    // p1.name = "James"
    p1.city = "Dallas"
    // p1.print() // not accessible, because the extension function is restricted to the package
}