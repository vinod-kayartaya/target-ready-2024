# Searching Algorithms

## Introduction to Searching:

Searching algorithms are fundamental techniques used in computer science to find a specific item or element within a collection of data. These algorithms are essential for various applications, including databases, information retrieval, and data analysis. The goal of a search algorithm is to efficiently locate the target item in the given dataset.

There are several types of searching algorithms, each with its own characteristics, advantages, and disadvantages. Some of the commonly used searching algorithms include:

1. Linear Search
2. Binary Search
3. Depth-First Search (DFS)
4. Breadth-First Search (BFS)
5. Interpolation Search
6. Exponential Search
7. Jump Search
8. Fibonacci Search
9. Ternary Search

Each of these algorithms has different time and space complexities, making them suitable for different scenarios based on the size and nature of the dataset.

## Linear Search: Algorithm, Implementation, Time Complexity

### Algorithm:

Linear search, also known as sequential search, is the simplest form of searching algorithm. It sequentially checks each element of the dataset until the target element is found or the entire dataset has been traversed. It is suitable for both sorted and unsorted datasets.

1. Start from the first element of the dataset.
2. Compare each element with the target element.
3. If the current element matches the target element, return its index.
4. If the end of the dataset is reached without finding the target element, return -1 (indicating that the element was not found).

### Time Complexity:

The time complexity of linear search is O(n), where n is the number of elements in the dataset. This is because, in the worst-case scenario, the algorithm may need to traverse the entire dataset to find the target element.

### Kotlin Implementation:

```kotlin
fun linearSearch(arr: IntArray, target: Int): Int {
    for (i in arr.indices) {
        if (arr[i] == target) {
            return i  // Element found, return its index
        }
    }
    return -1  // Element not found
}

fun main() {
    val arr = intArrayOf(5, 3, 9, 7, 2, 1, 6)
    val target = 7
    val index = linearSearch(arr, target)
    if (index != -1) {
        println("Element $target found at index $index")
    } else {
        println("Element $target not found")
    }
}
```

In this implementation:

- The `linearSearch` function takes an array `arr` and a target element `target` as parameters.
- It iterates through the array using a loop and checks if each element matches the target element.
- If the target element is found, it returns its index; otherwise, it returns -1.
- In the `main` function, we create an array `arr` and a target element `target`.
- We call the `linearSearch` function with the array and the target element.
- If the target element is found, it prints its index; otherwise, it prints a message indicating that the element was not found.

Linear search is straightforward and easy to implement but may not be efficient for large datasets, especially if the dataset is sorted and other search algorithms can be used.

## Binary Search: Algorithm, Implementation, Time Complexity

### Algorithm:

Binary search is a fast searching algorithm that works on sorted datasets. It repeatedly divides the search interval in half until the target element is found or the interval is empty. It compares the target element with the middle element of the dataset and eliminates half of the remaining elements from the search space based on the comparison.

1. Initialize two pointers, `low` and `high`, to the first and last indices of the dataset, respectively.
2. Repeat the following steps while `low` is less than or equal to `high`:
   - Calculate the middle index as `mid` = `(low + high) / 2`.
   - If the middle element is equal to the target element, return its index (`mid`).
   - If the middle element is greater than the target element, update `high` to `mid - 1`.
   - If the middle element is less than the target element, update `low` to `mid + 1`.
3. If the target element is not found after the loop, return -1.

### Time Complexity:

The time complexity of binary search is O(log n), where n is the number of elements in the sorted dataset. This is because the search interval is halved in each iteration, leading to a significant reduction in the search space.

### Kotlin Implementation:

```kotlin
fun binarySearch(arr: IntArray, target: Int): Int {
    var low = 0
    var high = arr.size - 1

    while (low <= high) {
        val mid = low + (high - low) / 2

        when {
            arr[mid] == target -> return mid
            arr[mid] < target -> low = mid + 1
            else -> high = mid - 1
        }
    }

    return -1  // Element not found
}

fun main() {
    val arr = intArrayOf(1, 2, 3, 5, 6, 7, 9)
    val target = 5
    val index = binarySearch(arr, target)
    if (index != -1) {
        println("Element $target found at index $index")
    } else {
        println("Element $target not found")
    }
}
```

In this implementation:

- The `binarySearch` function takes a sorted array `arr` and a target element `target` as parameters.
- It initializes two pointers, `low` and `high`, to the first and last indices of the dataset, respectively.
- It repeatedly divides the search interval in half until the target element is found or the interval is empty.
- If the target element is found, it returns its index; otherwise, it returns -1.
- In the `main` function, we create a sorted array `arr` and a target element `target`.
- We call the `binarySearch` function with the array and the target element.
- If the target element is found, it prints its index; otherwise, it prints a message indicating that the element was not found.

Binary search is highly efficient for searching in sorted datasets but requires the dataset to be sorted initially.

## Jump Search: Algorithm, Implementation, Time Complexity

### Algorithm:

Jump Search is a searching algorithm that works on sorted arrays. It jumps ahead by a fixed number of steps (block size) and checks if the target element lies between the current and previous block. If the target element is found within the block, a linear search is performed within that block. Otherwise, the algorithm continues to jump forward until the target element is found or it exceeds the array size.

1. Determine the block size (jump size). It is often chosen as the square root of the array size.
2. Jump forward by block size until the element at the current index is greater than or equal to the target element.
3. Perform a linear search within the current block, starting from the previous block's index.
4. If the target element is found within the block, return its index. Otherwise, return -1 (indicating that the element was not found).

### Time Complexity:

The time complexity of Jump Search is O(√n), where n is the number of elements in the sorted array. This is because the search interval is reduced by a factor of the square root of the array size in each iteration.

### Kotlin Implementation:

```kotlin
import kotlin.math.sqrt

fun jumpSearch(arr: IntArray, target: Int): Int {
    val n = arr.size
    val blockSize = sqrt(n.toDouble()).toInt()
    var prev = 0
    var curr = blockSize

    // Jump to the next block until the target element is greater than the current block's last element
    while (curr < n && arr[curr] < target) {
        prev = curr
        curr += blockSize
    }

    // Perform linear search within the current block
    for (i in prev..minOf(curr, n - 1)) {
        if (arr[i] == target) {
            return i  // Element found, return its index
        }
    }

    return -1  // Element not found
}

fun main() {
    val arr = intArrayOf(1, 3, 5, 7, 9, 11, 13, 15, 17, 19)
    val target = 7
    val index = jumpSearch(arr, target)
    if (index != -1) {
        println("Element $target found at index $index")
    } else {
        println("Element $target not found")
    }
}
```

In this implementation:

- The `jumpSearch` function takes a sorted array `arr` and a target element `target` as parameters.
- It determines the block size (jump size) as the square root of the array size.
- It jumps forward by the block size until the element at the current index is greater than or equal to the target element.
- It then performs a linear search within the current block, starting from the previous block's index.
- If the target element is found within the block, it returns its index; otherwise, it returns -1.
- In the `main` function, we create a sorted array `arr` and a target element `target`.
- We call the `jumpSearch` function with the array and the target element.
- If the target element is found, it prints its index; otherwise, it prints a message indicating that the element was not found.

Jump Search combines the advantages of linear search and binary search, providing better performance than linear search for large datasets while being simpler to implement than binary search.

## Fibonacci Search: Algorithm, Implementation, Time Complexity

## Algorithm:

Fibonacci Search is a searching algorithm that works on sorted arrays. It divides the array into smaller subarrays using Fibonacci numbers as indices. It compares the target element with the middle element of the current subarray. Based on the comparison, it either divides the search space further or identifies the target element.

1. Initialize two Fibonacci numbers, `fibM` and `fibM_minus_1`, such that they are the closest Fibonacci numbers to or equal to the length of the array.
2. Repeat the following steps until the subarray size becomes 1:
   - Compute the sum of `fibM_minus_1` and `fibM` to get the next Fibonacci number `fibM_plus_1`.
   - Update `fibM_minus_1` to `fibM` and `fibM` to `fibM_plus_1`.
   - Compare the target element with the middle element of the current subarray.
   - If the target element matches the middle element, return its index.
   - If the target element is less than the middle element, reduce the search space to the left half of the current subarray.
   - If the target element is greater than the middle element, reduce the search space to the right half of the current subarray.
3. If the target element is not found after the loop, return -1 (indicating that the element was not found).

## Time Complexity:

The time complexity of Fibonacci Search is O(log n), where n is the number of elements in the sorted array. This is because the search interval is halved in each iteration, similar to binary search. However, Fibonacci Search divides the array into subarrays using Fibonacci numbers, which allows for more efficient searching.

## Kotlin Implementation:

```kotlin
fun fibonacciSearch(arr: IntArray, target: Int): Int {
    val n = arr.size
    var fibM_minus_2 = 0
    var fibM_minus_1 = 1
    var fibM = fibM_minus_1 + fibM_minus_2

    // Find the smallest Fibonacci number greater than or equal to n
    while (fibM < n) {
        fibM_minus_2 = fibM_minus_1
        fibM_minus_1 = fibM
        fibM = fibM_minus_1 + fibM_minus_2
    }

    var offset = -1

    // Perform Fibonacci Search
    while (fibM > 1) {
        val i = minOf(offset + fibM_minus_2, n - 1)

        if (arr[i] == target) {
            return i  // Element found, return its index
        } else if (arr[i] < target) {
            fibM = fibM_minus_1
            fibM_minus_1 = fibM_minus_2
            fibM_minus_2 = fibM - fibM_minus_1
            offset = i
        } else {
            fibM = fibM_minus_2
            fibM_minus_1 -= fibM_minus_2
            fibM_minus_2 = fibM - fibM_minus_1
        }
    }

    // Check if the last element is the target
    if (fibM_minus_1 == 1 && arr[offset + 1] == target) {
        return offset + 1
    }

    // Element not found
    return -1
}

fun main() {
    val arr = intArrayOf(1, 3, 5, 7, 9, 11, 13, 15, 17, 19)
    val target = 7
    val index = fibonacciSearch(arr, target)
    if (index != -1) {
        println("Element $target found at index $index")
    } else {
        println("Element $target not found")
    }
}
```

In this implementation:

- The `fibonacciSearch` function takes a sorted array `arr` and a target element `target` as parameters.
- It initializes Fibonacci numbers and finds the smallest Fibonacci number greater than or equal to the length of the array.
- It performs Fibonacci Search to search for the target element in the array.
- If the target element is found, it returns its index; otherwise, it returns -1.
- In the `main` function, we create a sorted array `arr` and a target element `target`.
- We call the `fibonacciSearch` function with the array and the target element.
- If the target element is found, it prints its index; otherwise, it prints a message indicating that the element was not found.

Fibonacci Search is a more efficient variant of binary search, especially for large datasets, due to its better distribution of subarrays. However, it requires additional calculations to determine the Fibonacci numbers and has a higher overhead compared to binary search.

## Comparison

Let's compare Binary Search, Linear Search, Jump Search, and Fibonacci Search in terms of ease of implementation and time complexity:

### Ease of Implementation:

1. **Linear Search:**

   - **Ease of Implementation:** Linear search is the simplest among the four algorithms. It involves iterating through each element of the array until the target element is found.
   - **Implementation Complexity:** Linear search can be implemented with a basic loop and conditional statements, making it easy to understand and implement.

2. **Binary Search:**

   - **Ease of Implementation:** Binary search is relatively straightforward to implement once the array is sorted. However, understanding the concept of dividing the search space in half may require some additional understanding.
   - **Implementation Complexity:** Binary search involves recursive or iterative algorithms that require careful handling of indices and comparisons. While not as simple as linear search, it is still relatively easy to implement correctly.

3. **Jump Search:**

   - **Ease of Implementation:** Jump search is slightly more complex than linear search due to the concept of jumping ahead by a fixed number of steps. However, it is still relatively easy to implement compared to binary search.
   - **Implementation Complexity:** Jump search requires determining the jump size and performing a linear search within each block. It involves a mix of linear search and simple arithmetic operations.

4. **Fibonacci Search:**
   - **Ease of Implementation:** Fibonacci search is more complex to implement compared to linear and jump search. It involves additional calculations to determine Fibonacci numbers and handling multiple variables.
   - **Implementation Complexity:** Fibonacci search involves more complex logic compared to linear and jump search. It requires careful handling of Fibonacci numbers and updating indices based on comparisons.

### Time Complexity:

1. **Linear Search:**

   - **Time Complexity:** O(n) - Linear search has a time complexity of O(n) since it iterates through each element of the array sequentially.
   - **Remarks:** Linear search is efficient for small arrays but becomes inefficient for large arrays due to its linear time complexity.

2. **Binary Search:**

   - **Time Complexity:** O(log n) - Binary search has a time complexity of O(log n) since it divides the search space in half with each iteration.
   - **Remarks:** Binary search is highly efficient for large sorted arrays but requires the array to be sorted initially.

3. **Jump Search:**

   - **Time Complexity:** O(√n) - Jump search has a time complexity of O(√n) since it performs block jumps of a fixed size and then performs linear search within each block.
   - **Remarks:** Jump search provides better performance than linear search but may not be as efficient as binary search for large datasets.

4. **Fibonacci Search:**
   - **Time Complexity:** O(log n) - Fibonacci search also has a time complexity of O(log n) similar to binary search, but with a different distribution of subarrays.
   - **Remarks:** Fibonacci search offers better performance than jump search in terms of reducing the search space but involves additional overhead due to Fibonacci number calculations.
