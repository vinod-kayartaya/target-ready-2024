package com.targetindia.stack

import com.targetindia.stack.sll.SinglyLinkedListStack


fun main() {
    val stack: Stack = SinglyLinkedListStack()

    do {
        // display the current values of the stack first
        stack.display()

        println("*** Main Menu***")
        println("0. Exit")
        println("1. Push")
        println("2. Pop")
        println("3. Peek")
        println("4. Check if empty")
        println("5. Check size")
        var choice: Int = -1
        try {
            choice = readInt("enter your choice: ")
        } catch (e: Exception) {
            println(e.message)
            continue
        }

        when (choice) {
            0 -> println("exiting...")
            1 -> {
                try {
                    val value = readInt("enter a number to push into the stack: ")
                    stack.push(value)
                    println("$value pushed to the stack")
                } catch (e: Exception) {
                    println(e.message)
                }
            }

            2 -> {
                try {
                    println("popped number is ${stack.pop()}")
                } catch (e: Exception) {
                    println(e.message)
                }
            }

            3 -> {
                try {
                    println("top value in the stack is ${stack.peek()}")
                } catch (e: Exception) {
                    println(e.message)
                }
            }

            4 -> println("stack is empty --> ${stack.isEmpty()}")
            5 -> println("stack size = ${stack.size()}")
            else -> println("invalid choice. please try again.")
        }

        println()

    } while (choice != 0)

}

fun readInt(prompt: String): Int {
    print(prompt)
    try {
        return readln().toInt()
    } catch (e: Exception) {
        throw RuntimeException("please retry with an integer")
    }
}