package com.targetindia.programs


class Address {
    var city:String = ""

    fun print() {
        println("city = $city")
    }

    companion object {
        fun create(): Address = Address()
    }
}

fun main() {
    val addr1 = Address.create()
    val addr2 = Address.create()

    addr1.city = "Bangalore"
    addr2.city = "Mysore"

    addr1.print()
    addr2.print()
}