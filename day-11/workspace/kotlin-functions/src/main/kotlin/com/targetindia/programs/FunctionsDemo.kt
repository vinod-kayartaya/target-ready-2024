package com.targetindia.programs

fun greet() {
    println("Hello, world!")
}

fun sayHello(name: String) {
    println("Hello, $name")
}

fun sayHello(friend: String="friend", city: String="your city") {
    println("Hello, $friend. How's weather in $city?")
}

fun main() {
    greet()
    sayHello("Murali")
    sayHello("Kumara", "Shivamogga")
    sayHello(city = "Bangalore", friend = "Naveen")
    sayHello(city="Chennai")
    sayHello(friend="Ravi")
    sayHello()
}