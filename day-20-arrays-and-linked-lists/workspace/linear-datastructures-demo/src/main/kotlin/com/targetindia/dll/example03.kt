package com.targetindia.dll

import com.targetindia.arrays.readInt

class Node(var data: Int) {
    var prev: Node? = null
    var next: Node? = null
}

class DoublyLinkedList {
    private var head: Node? = null
    private var tail: Node? = null

    fun append(value: Int) {
        val newNode = Node(value) // O(1)

        if (head == null) { // O(1)
            head = newNode // O(1)
            tail = newNode // O(1)
            return // O(1)
        }

        tail?.next = newNode // O(1)
        newNode.prev = tail // O(1)
        tail = newNode // O(1)
    }  // O(1)

    fun prepend(value: Int) {
        val newNode = Node(value)

        if (head == null) { // O(1)
            head = newNode // O(1)
            tail = newNode // O(1)
            return // O(1)
        }

        head?.prev = newNode // O(1)
        newNode.next = head // O(1)
        head = newNode // O(1)
    } // O(1)

    fun printForward() {
        print("start <-> ")
        var currNode = head // O(1)
        while (currNode != null) { // O(n)
            print("${currNode.data} <-> ")
            currNode = currNode.next // O(1)
        }
        println("end")
    }

    fun printBackward() {
        print("end <-> ")
        var curr = tail
        while (curr != null) {
            print("${curr.data} <-> ")
            curr = curr.prev
        }
        println("start")
    }

    fun deleteValue(value: Int): Boolean {
        var curr = head // O(1)
        var found = false // O(1)
        while (curr != null) { // O(n)
            if (curr.data == value) { // O(1)
                found = true // O(1)

                if (curr.prev != null) { // O(1)
                    curr.prev!!.next = curr.next // O(1)
                } else { // O(1)
                    head = curr.next // O(1)
                }

                if (curr.next != null) { // O(1)
                    curr.next!!.prev = curr.prev // O(1)
                } else { // O(1)
                    tail = curr.prev // O(1)
                }

                curr.prev = null // O(1)
                curr.next = null // O(1)
                break // the loop since we already found the element to be deleted // O(1)
            }

            curr = curr.next // O(1)
        }

        return found // O(1)
    }
}


fun main() {
    val list = DoublyLinkedList()

    do {
        list.printForward()

        println("0. Exit")
        println("1. Append")
        println("2. Prepend")
        println("3. Print backwards")
        println("4. Insert a number at a given index") // Assignment task
        println("4. Delete a number at a given index") // Assignment task
        println("5. Search a number in the list") // Assignment task
        println("6. Delete a number by value")
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
                list.printBackward()
            }

            6 -> {
                val value = readInt("Enter value to delete: ")
                if(!list.deleteValue(value)){
                    println("$value not found in the list")
                }
            }

            else -> println("Invalid choice")
        }

    } while (choice != 0)
}