package com.targetindia.queue

import com.targetindia.queue.dll.DoublyLinkedListQueue


fun main() {
    val queue: Queue<Int> = DoublyLinkedListQueue()

    do {
        // display the current values of the stack first
        queue.display()

        println("*** Main Menu***")
        println("0. Exit")
        println("1. Enqueue")
        println("2. Dequeue")
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
                    val value = readInt("enter a number to enqueue in the queue: ")
                    queue.enqueue(value)
                    println("$value enqueued in the queue")
                } catch (e: Exception) {
                    println(e.message)
                }
            }

            2 -> {
                try {
                    println("dequeued number is ${queue.dequeue()}")
                } catch (e: Exception) {
                    println(e.message)
                }
            }

            3 -> {
                try {
                    println("top value in the queue is ${queue.peek()}")
                } catch (e: Exception) {
                    println(e.message)
                }
            }

            4 -> println("queue is empty --> ${queue.isEmpty()}")
            5 -> println("queue size = ${queue.size()}")
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