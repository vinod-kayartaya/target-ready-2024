package com.targetindia.stack

interface Stack {
    fun push(value: Int)
    fun display()
    fun isEmpty(): Boolean
    fun size(): Int
    fun pop(): Int
    fun peek(): Int
}