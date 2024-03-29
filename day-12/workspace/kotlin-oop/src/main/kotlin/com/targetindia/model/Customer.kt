package com.targetindia.model

class Customer {
    var name = ""
    var city = ""
    var email = ""

    constructor()

    constructor(name: String, city: String = "Bangalore", email: String) {
        this.name = name
        this.city = city
        this.email = email
    }

    fun getAsCsv(): String {
        return "$name,$city,$email"
    }

    fun getAsJson(): String {
        return """{
            |"name": "$name",
            |"city": "$city",
            |"email": "$email"
            |}""".trimMargin()
    }

    fun print(): Unit {
        println("Name    : $name")
        println("City    : $city")
        println("Email   : $email")
    }
}