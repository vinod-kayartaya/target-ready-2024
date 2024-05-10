package com.targetindia.programs

import com.targetindia.model.Person

// accessible inside the current package --> com.targetindia.programs
fun Person.print() {
    println("Name = $name")
    println("City = $city")
}


var Person.name: String
    get() = ""
    set(value) {
        if (value.trim().length < 3) {
            throw RuntimeException("minimum length must be 3")
        }
        value
    }

fun String.quoted(): String {
    return "\"$this\""
}

fun String.boxed(): String {
    return """
        .${"-".repeat(this.length)}.
        |$this|
        .${"-".repeat(this.length)}.
    """.trimIndent()
}

fun main() {
    val myName = "Vinod Kumar";
    println(myName)
    println(myName.reversed())
    println(myName.lowercase())
    println(myName.uppercase())
    println(myName.quoted())
    println("Kotlin is super cool".boxed())

    val p1: Person = Person()
    p1.name = "Vinod"
    p1.city = "Bangalore"

    p1.print()
}
