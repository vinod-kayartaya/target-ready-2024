package com.targetindia.queue.dll

import com.targetindia.queue.Queue

class DoublyLinkedListQueue<T> : Queue<T> {

    private class Node<T>(val data: T) {
        var prev: Node<T>? = null
        var next: Node<T>? = null
    }

    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    private var _size = 0

    override fun enqueue(data: T) {
        val newNode = Node(data)
        if (isEmpty()) {
            head = newNode
            tail = newNode
        } else {
            tail!!.next = newNode
            newNode.prev = tail
            tail = newNode
        }
        _size++
    }

    override fun dequeue(): T {
        if (isEmpty()) {
            throw RuntimeException("queue is empty; nothing to dequeue.")
        }
        _size--
        val data = head!!.data

        if (head == tail) {
            head = null
            tail = null
        } else {
            val curr = head
            head = head!!.next
            head!!.prev = null
            curr!!.next = null
        }
        return data
    }

    override fun peek(): T {
        if (isEmpty()) {
            throw RuntimeException("queue is empty; nothing to peek.")
        }
        return head!!.data
    }

    override fun isEmpty(): Boolean {
        return head == null && tail == null
    }

    override fun display() {
        if (isEmpty()) {
            println("queue is empty!")
            return
        }

        print("start")
        var curr = head
        while (curr != null) {
            print(" <- ${curr.data}")
            curr = curr.next
        }
        println(" <- end")
    }

    override fun size(): Int {
        return _size
    }
}