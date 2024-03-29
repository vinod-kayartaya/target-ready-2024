package com.targetindia.programs

import com.targetindia.model.Book
import com.targetindia.model.Person


fun main() {
    val p1 = Person()
    println("p1 is $p1")

    val p2 = Person()
    p2.name = "Vinod" // call to the p2.setName("Vinod")
    p2.city = "Bangalore"
    p2.age = 50
    println("p2 is $p2")

    val b1 = Book("Let us C", 399.0)
    println("b1 is $b1")
    b1.price = 459.0
    println("b1 is $b1")

    val b2 = Book()
    b2.title = "Java Unleashed"
    b2.price = 1902.0
    println("b2 is $b2")

    val b3 = Book(price = 999.0)
    b3.title = "Let us Java"
    println("b3 is $b3")

    val b4 = Book("Java Complete Reference")
    b4.price = 1299.0
    println("b4 is $b4")


}