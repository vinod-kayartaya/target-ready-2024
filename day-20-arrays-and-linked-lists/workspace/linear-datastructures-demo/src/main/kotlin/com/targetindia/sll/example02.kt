package com.targetindia.sll

import com.targetindia.arrays.readInt

class Node(var data: Int) {
    var next: Node? = null;
}

class SinglyLinkedList { // O(n)

    private var head: Node? = null

    fun print() {
        print("start -> ")
        var currNode = head // O(1)
        while (currNode != null) { // O(n)
            print("${currNode.data} -> ")
            currNode = currNode.next // O(1)
        }
        println("end")
    }

    fun append(value: Int) {
        val newNode = Node(value) // O(1)

        if (head == null) { // O(1)
            head = newNode // O(1)
            return // O(1)
        }

        var currNode = head // O(1)
        while (currNode?.next != null) { // O(n)
            currNode = currNode.next // O(1)
        }
        currNode?.next = newNode // O(n)
    }

    fun prepend(value: Int) {
        val newNode = Node(value) // O(1)
        newNode.next = head // O(1)
        head = newNode // O(1)
    } // O(1)

    fun reverse() {
        var prev: Node? = null // O(1)
        var curr = head // O(1)
        var next: Node? // O(1)

        while (curr != null) { // O(n)
            next = curr.next // O(1)
            curr.next = prev // O(1)
            prev = curr // O(1)
            curr = next // O(1)
        }
        head = prev // O(1)
    } // O(n)
}

fun main() {
    val list = SinglyLinkedList()

    do {
        list.print()

        println("0. Exit")
        println("1. Append")
        println("2. Prepend")
        println("3. Reverse")
        println("4. Insert a number at a given index") // Assignment task
        println("4. Delete a number at a given index") // Assignment task
        println("5. Search a number in the list") // Assignment task
        val choice = readInt("Enter your choice: ")

        when (choice) {
            0 -> {
                println("Exiting...")
            }

            1 -> {
                val value = readInt("Enter value to append: ")
                list.append(value)
            }

            2 -> {
                val value = readInt("Enter value to prepend: ")
                list.prepend(value)
            }

            3 -> {
                list.reverse()
            }

            else -> println("Invalid choice")
        }

    } while (choice != 0)
}