package com.targrtindia.searching

import kotlin.math.sqrt
import kotlin.random.Random

fun main() {
    val array = Array(25) { it * 3 }

    while (true) {
        println("Array elements: ${array.joinToString(", ")}")
        println("\n***Main menu***")
        println("0. Exit")
        println("1. Linear search")
        println("2. Binary search")
        println("3. Jump search")

        print("Enter your choice: ")

        when (val choice = readlnOrNull()?.toIntOrNull()) {
            0 -> {
                println("Exiting...")
                break
            }

            1, 2, 3 -> {
                print("Enter the number to search: ")
                val num = readlnOrNull()?.toIntOrNull() ?: continue
                val index = when (choice) {
                    1 -> linearSearch(array, num)
                    2 -> binarySearch(array, num)
                    3 -> jumpSearch(array, num)
                    else -> -1
                }

                if (index == -1) {
                    println("$num does not exist in the dataset")
                } else {
                    println("$num is found in the index $index of the dataset")
                }
            }

            else -> println("Invalid choice. Please try again.")
        }
    }
}

fun linearSearch(arr: Array<Int>, target: Int): Int {
    for (index in arr.indices) {
        if (target == arr[index]) {
            return index
        }
    } // O(n)
    return -1 // indicating that the search failed
}

fun binarySearch(arr: Array<Int>, target: Int): Int {
    var low = 0
    var high = arr.lastIndex

    while (low <= high) {
        val mid = (low + high) / 2

        when {
            target == arr[mid] -> return mid
            target < arr[mid] -> high = mid - 1
            else -> low = mid + 1
        }
    }
    return -1 // indicating that the search failed
}

fun jumpSearch(arr: Array<Int>, target: Int): Int {
    val blockSize = sqrt(arr.size.toDouble()).toInt()
    var prev = 0
    var curr = blockSize

    while(curr < arr.size && target >= arr[curr]){
        prev = curr
        curr += blockSize
    }

    // [0, 3, 6, 9, 12], [15, 18, 21, 24, 27], [30, 33, 36, 39, 42], [45, 48, 51, 54, 57], [60, 63, 66, 69, 72]
    for(i in prev..<minOf(curr, arr.size)){
        if(target==arr[i]){
            return i
        }
    }

    return -1 // indicating that the search failed
}