package com.targetindia.stack.sll

import com.targetindia.stack.Stack


class SinglyLinkedListStack : Stack {


    private class Node(val data: Int) {
        var next: Node? = null
    }

    private var top: Node? = null
    var _size = 0

    override fun push(value: Int) {
        val newNode = Node(value) // O(1)
        newNode.next = top // O(1)
        top = newNode // O(1)
        _size++
    }

    override fun display() {
        if (isEmpty()) {
            println("stack is empty")
            return
        }

        print("Top")
        var curr = top
        while (curr != null) {
            print(" <- ${curr.data}")
            curr = curr.next
        }
        println()
    }

    override fun isEmpty(): Boolean {
        return top == null
    }

    override fun size(): Int {
        return _size
    }

    override fun pop(): Int {
        if (isEmpty()) {
            throw RuntimeException("stack is empty; pop not possible")
        }

        _size--
        val curr = top
        top = top!!.next

        curr!!.next = null
        return curr!!.data
    }

    override fun peek(): Int {
        if (isEmpty()) {
            throw RuntimeException("stack is empty; nothing to peek")
        }

        return top!!.data
    }
}
