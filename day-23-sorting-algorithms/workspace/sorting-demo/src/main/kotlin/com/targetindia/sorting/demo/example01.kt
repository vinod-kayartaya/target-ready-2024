package com.targetindia.sorting.demo

import kotlin.random.Random

// Assignment task:
// Implement these sort functionalities on a linked list (singly/doubly)
fun main() {
    val array = Array(8) { Random.nextInt(100) }

    the_loop@ while (true) {
        println("Array content: ${array.joinToString(", ")}")

        println("\n*** Main menu ***")
        println("0. Exit")
        println("1. Shuffle")
        println("2. Bubble sort")
        println("3. Selection sort")
        println("4. Insertion sort")
        println("5. Merge sort")
        print("Enter your choice: ")

        when (readlnOrNull()?.toInt()) {
            0 -> break@the_loop
            1 -> array.shuffle()
            2 -> bubbleSort(array)
            3 -> selectionSort(array)
            4 -> insertionSort(array)
            5 -> mergeSort(array)
        }
    }
}


fun bubbleSort(array: Array<Int>) {
    for (i in 0..<array.lastIndex) {
        for (j in 0..<array.lastIndex - i) {
            if (array[j] > array[j + 1]) {
                val temp = array[j]
                array[j] = array[j + 1]
                array[j + 1] = temp
            }
        }
    }
} // time complexity ---> O(n^2)

/*
- The array is divided into 2 sections - sorted and unsorted
- In the beginning, the sorted section contains 0 elements, the unsorted section contains all elements
- Find the smallest (or minimum valued) element in the unsorted section
- Swap the minimum element with the first element of the unsorted section
- Move the sub-array boundary one element to the right
- Repeat this process, until the number of elements in the unsorted section becomes 0
 */
fun selectionSort(array: Array<Int>) {
    val n = array.size
    for (i in 0..<n - 1) {
        var minIndex = i
        for (j in i + 1..<n) {
            if (array[j] < array[minIndex]) {
                minIndex = j
            }
        }

        if (minIndex == i) continue

        println("Array = ${array.joinToString(", ")}, minIndex = $minIndex")

        // swap the element at minIndex with element at index i
        val temp = array[i]
        array[i] = array[minIndex]
        array[minIndex] = temp
    }
}


/*
- comparison based sorting algorithm
- start with the 2nd element, and consider this to be the `key` to be inserted into the sorted sub array
- compare the key with the elements to its left in the sorted sub array, and move the elements bigger than the key
  to one position right, until the correct position of the key is found
- insert the key in the position found
- repeat the process for all elements in the unsorted section
 */
fun insertionSort(array: Array<Int>) {
    val n = array.size
    for (i in 1..<n) {
        val key = array[i]
        var j = i - 1
        while (j >= 0 && array[j] > key) {
            array[j + 1] = array[j]
            j--
        }
        array[j + 1] = key
    }
}
// worst/average case time complexity --> O(n^2)
// best case time complexity --> O(n)

/*
- Divide ==> the array to be sorted is divided recursively into two halves until each sub-array contains only one element
- Conquer ==> each sub-array contains exactly one element, (in sorted order, by default)
- Merge ==> while merging the sorted sub-arrays, the merged array is again sorted
- Repeat
 */
fun mergeSort(array: Array<Int>) {
    if (array.size > 1) {

        val mid = array.size / 2
        val left = array.sliceArray(0..<mid)
        val right = array.sliceArray(mid..<array.size)

        // println("left: ${left.joinToString(", ")}, right: ${right.joinToString(", ")}")

        mergeSort(left)
        mergeSort(right)

        var i = 0
        var j = 0
        var k = 0

        while (i < left.size && j < right.size) {
            if (left[i] < right[j]) {
                array[k++] = left[i++]
            } else {
                array[k++] = right[j++]
            }
        }

        while (i < left.size) {
            array[k++] = left[i++]
        }
        while (j < right.size) {
            array[k++] = right[j++]
        }

        // println("array: ${array.joinToString(", ")}")
    }
}
// worst case time complexity --> O(n log(n))