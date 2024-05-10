package com.targetindia.programs

fun sayHello(name: String?) {
    println("Hello, ${name ?: "friend"}. Your name is made up of ${name?.length ?: "unknown number of"} letters.")
}

fun main() {
    var name: String? = "Shyam"
    sayHello("Vinod")
    println("name is $name")
    sayHello(name)
    name = null
    sayHello(name)

    val message = "Hello, ${if (name == null) "friend" else name}"
    println(message)
}