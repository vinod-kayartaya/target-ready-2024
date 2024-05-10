package com.targetindia.programs

// single expression function
// fun cube(n: Int): Int = n * n * n

// val cube:<TypeOfCube> = <lambda expression>
val cube: (Int) -> Int = { num -> num * num * num }
val length: (String) -> Int = { str -> str.length }
// In java
// Comparator<Integer> intComparator = (a, b) -> Integer.compare(b, a)

// In JavaScript
// const cube = (x) => x*x*x

// In Python
// cube = lambda(x) = x*x*x
fun main() {
    print("enter a number: ")
    val n = readln().toInt()
    val c = cube(n)
    println("cube of $n is $c")
    val name = "Vinod Kumar";
    println("length of '$name' is ${length(name)}")
}