package com.targetindia.programs

// import com.targetindia.programs.factorial // not required for the same package members
// in effect --> import static com.targetindia.programs.MoreFunctionsDemoKt.factorial
import kotlin.math.sqrt // `kotlin.math` is a package in a `file`, where sqrt is a function
// In java --> import static java.lang.Math.sqrt
fun main(){
    print("enter a number: ")
    val n = readln().toInt()
    val f = factorial(n) // automatically imported, since it is in the same package (although in different file)
    val sr = sqrt(n*1.0)
    println("factorial of $n is $f")
    println("square root of $n is $sr")
}