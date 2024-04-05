package com.targetindia.programs

fun main() {
    val numbers = mutableListOf<Int>(29, 49, 29, 49, 299, 299, 190, 29, 49, 299, 38, 29, 49, 299, 48, 223, 48)
    numbers.add(999)
    println(numbers)
    println("numbers is a list of type ${numbers.javaClass.name}")

    val uniqueNumbers = mutableSetOf<Int>(29, 49, 29, 49, 299, 299, 190, 29, 49, 299, 38, 29, 49, 299, 48, 223, 48)
    uniqueNumbers.add(999)
    println(uniqueNumbers)
    println("uniqueNumbers is set of type ${uniqueNumbers.javaClass.name}")

    val config = mutableMapOf<String, String>(
        "cpu" to "2.9 GHz 12 core Intel",
        "ram" to "32 GB DDR2",
        "storage" to "1TB SSD",
        "ram" to "16 GB DDR2"
    )
    // config.put("display", "unknown")
    config["display"] = "unknown"
    println(config)
    println("config is set of type ${config.javaClass.name}")

    config.forEach{(k, v)-> println("$k --> $v")}
    println("ram is ${config["ram"]}")

    val numberSequence = sequenceOf(29, 39, 22, 39)
    println(numberSequence)
    println("numberSequence is set of type ${numberSequence.javaClass.name}")
    for(i in numberSequence){
        println("i is $i")
    }


}