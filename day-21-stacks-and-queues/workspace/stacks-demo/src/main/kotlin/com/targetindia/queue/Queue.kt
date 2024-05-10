package com.targetindia.queue

interface Queue<T> {
    fun enqueue(data: T)
    fun dequeue(): T
    fun peek(): T
    fun isEmpty(): Boolean
    fun display()
    fun size(): Int
}