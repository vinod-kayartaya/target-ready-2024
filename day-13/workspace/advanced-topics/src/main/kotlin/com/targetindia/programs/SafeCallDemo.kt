package com.targetindia.programs

class Person(val name: String = "", val city: String = "")


fun printPersonData(person: Person?) {
    person?.let {
        println("Name  = ${it.name}")
        println("City  = ${it.city}")
        println()
    }
}

fun main() {
    val p1: Person? = null
    val p2: Person? = Person("Vinod", "Bengaluru")

    printPersonData(p1)
    printPersonData(p2)
}

