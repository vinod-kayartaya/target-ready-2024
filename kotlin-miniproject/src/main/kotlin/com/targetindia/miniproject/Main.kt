package com.targetindia.miniproject

fun menu(): Int {
    print(
        """*** Main Menu ***
        |0. Exit
        |1. List all customers
        |2. Add new customer data
        |3. Search customer by id
        |
        |Enter your choice: 
    """.trimMargin()
    )

    try {
        return readln().toInt()
    } catch (e: Exception) {
        return -1
    }
}

fun main() {

    theLoop@
    while (true) {
        when (menu()) {
            0 -> break@theLoop
            1 -> {
                // to be done later
                println("list of customers not available yet")
            }

            2 -> {
                // to be done later
                println("add new customer not available yet")
            }

            3 -> {
                // to be done later
                println("search customer by id not available yet")
            }

            else -> {
                println("invalid choice. please retry.")
            }
        }

    }

}