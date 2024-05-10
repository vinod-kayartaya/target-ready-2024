package com.targetindia.stack.array

import com.targetindia.stack.Stack


class ArrayStack:Stack {
    private var capacity = 5
    private var array = IntArray(capacity)
    private var top = -1

    override fun push(value: Int) {
        if (top == capacity - 1) {
            expandCapacity()
        }
        array[++top] = value
    }

    private fun expandCapacity() {
        capacity *= 2
        // val newArray = array.copyOf(capacity)
        val newArray = IntArray(capacity)
        for (i in array.indices) {
            newArray[i] = array[i]
        }
        array = newArray
    }

    override fun isEmpty(): Boolean {
        return top == -1
    }

    override fun display() {
        if (isEmpty()) {
            println("stack is empty!")
            return
        }

        print("top")
        for (i in top downTo 0) { // for(i in top downTo 0){
            print(" <- ${array[i]}")
        }
        println()
    }

    override fun peek(): Int {
        if (top == -1) {
            throw RuntimeException("stack is empty; nothing to peek")
        }

        return array[top]
    }

    override fun pop(): Int {
        if (top == -1) {
            throw RuntimeException("stack is empty; pop not possible")
        }

        return array[top--]
    }

    override fun size(): Int {
        return top + 1
    }
}
