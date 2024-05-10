# Stacks and Queues

## Introduction to Stacks: Definition, Operations (Push, Pop, Peek), Applications

Stacks are a fundamental data structure in computer science that follow the Last In, First Out (LIFO) principle. This means that the last element added to the stack is the first one to be removed. Stacks can be visualized as a stack of plates where you can only add or remove plates from the top.

### Definition:

A stack is a collection of elements with two primary operations: push and pop. Elements are added and removed from the top of the stack.

### Operations:

1. **Push:** Adds an element to the top of the stack.
2. **Pop:** Removes the top element from the stack.
3. **Peek (or Top):** Returns the top element of the stack without removing it.

### Applications:

1. **Expression Evaluation:** Stacks can be used to evaluate infix, postfix, or prefix expressions.
2. **Function Calls:** Function call history can be managed using stacks, enabling features like recursion and undo functionality.
3. **Parsing:** Stacks can be used in syntax parsing, such as in the parsing of HTML or XML documents.
4. **Backtracking:** Stacks can be utilized in algorithms that require backtracking, such as maze-solving algorithms or depth-first search.
5. **Undo Operations:** Stacks can facilitate undo functionality in applications where users can revert their actions step by step.

Stacks provide efficient insertion and deletion of elements at one end (top), making them suitable for scenarios where elements are frequently added or removed in a sequential manner. Their simplicity and versatility make them an essential concept in computer science and software development.

## Implementation of Stack using arrays and linked lists

Let's implement a stack using both arrays and linked lists in Kotlin.

### Stack Implementation using Arrays:

```kotlin
class ArrayStack<T>(private val capacity: Int) {
    private val array = arrayOfNulls<Any>(capacity)
    private var top = -1

    fun push(item: T) {
        if (top == capacity - 1) {
            throw IllegalStateException("Stack overflow")
        }
        top++
        array[top] = item
    }

    fun pop(): T? {
        if (isEmpty()) {
            return null
        }
        val item = array[top] as T
        array[top] = null
        top--
        return item
    }

    fun peek(): T? {
        return if (isEmpty()) {
            null
        } else {
            array[top] as T
        }
    }

    fun isEmpty(): Boolean {
        return top == -1
    }

    fun size(): Int {
        return top + 1
    }
}
```

### Stack Implementation using Linked List:

```kotlin
class Node<T>(val data: T, var next: Node<T>? = null)

class LinkedListStack<T> {
    private var top: Node<T>? = null

    fun push(item: T) {
        val newNode = Node(item)
        newNode.next = top
        top = newNode
    }

    fun pop(): T? {
        if (isEmpty()) {
            return null
        }
        val item = top!!.data
        top = top!!.next
        return item
    }

    fun peek(): T? {
        return top?.data
    }

    fun isEmpty(): Boolean {
        return top == null
    }

    fun size(): Int {
        var count = 0
        var current = top
        while (current != null) {
            count++
            current = current.next
        }
        return count
    }
}
```

### Explanation:

- **Array Stack:** This implementation utilizes an array to store the elements of the stack. The `push` operation adds elements to the top of the stack, `pop` removes the top element, and `peek` returns the top element without removing it. The size of the array is fixed upon initialization.

- **Linked List Stack:** Here, we use a singly linked list to implement the stack. Nodes are linked together, with each node containing an element and a reference to the next node. `push` adds a new node to the beginning of the list, `pop` removes the first node, and `peek` returns the data of the first node without removing it.

Both implementations provide the same stack functionality, but they differ in terms of underlying data structure and operations' time complexity. Array-based stacks offer constant time complexity for accessing elements (`peek`), but resizing the array may lead to occasional linear time complexity for `push` operations. On the other hand, linked list-based stacks provide constant time complexity for `push` and `pop` operations but may have slightly higher overhead due to node creation. The choice between them depends on factors like expected usage patterns, memory constraints, and performance requirements.

## Introduction to Queues: Definition, Operations (Enqueue, Dequeue), Applications

Queues are another fundamental data structure in computer science, operating on the principle of First In, First Out (FIFO). In a queue, elements are inserted at the rear and removed from the front. Think of it like a line at a ticket counter or a queue of tasks waiting to be processed by a computer program.

### Definition:

A queue is a collection of elements that supports two primary operations: enqueue and dequeue. Elements are added at the rear (enqueue) and removed from the front (dequeue) of the queue.

### Operations:

1. **Enqueue:** Adds an element to the rear of the queue.
2. **Dequeue:** Removes and returns the front element of the queue.
3. **Peek (or Front):** Returns the front element of the queue without removing it.

### Applications:

1. **Breadth-First Search (BFS):** Queues are used extensively in graph traversal algorithms like BFS, where nodes are explored level by level.
2. **Resource Allocation:** Queues are used to manage resources such as printers, CPU processes, and network requests, ensuring fair access and preventing resource starvation.
3. **Buffering:** Queues are employed in buffering systems to store and manage data temporarily, smoothing out variations in data production and consumption rates.
4. **Task Scheduling:** Queues are utilized in task scheduling systems, such as job scheduling in operating systems or task queues in web servers, to prioritize and execute tasks in an organized manner.
5. **Event Handling:** Queues are used in event-driven programming paradigms to manage and process events in the order they occur.

Queues provide efficient insertion and removal of elements at opposite ends, making them suitable for scenarios where elements need to be processed in the order they arrive. Their simplicity and versatility make them an indispensable tool in various domains of computer science and software engineering.

## Implementation of Queue using arrays and linked lists

Let's implement a queue using both arrays and linked lists in Kotlin.

### Queue Implementation using Arrays:

```kotlin
class ArrayQueue<T>(private val capacity: Int) {
    private val array = arrayOfNulls<Any>(capacity)
    private var front = 0
    private var rear = -1
    private var size = 0

    fun enqueue(item: T) {
        if (isFull()) {
            throw IllegalStateException("Queue is full")
        }
        rear = (rear + 1) % capacity
        array[rear] = item
        size++
    }

    fun dequeue(): T? {
        if (isEmpty()) {
            return null
        }
        val item = array[front] as T
        array[front] = null
        front = (front + 1) % capacity
        size--
        return item
    }

    fun peek(): T? {
        return if (isEmpty()) {
            null
        } else {
            array[front] as T
        }
    }

    fun isEmpty(): Boolean {
        return size == 0
    }

    fun isFull(): Boolean {
        return size == capacity
    }

    fun size(): Int {
        return size
    }
}
```

### Queue Implementation using Linked List:

```kotlin
class Node<T>(val data: T, var next: Node<T>? = null)

class LinkedListQueue<T> {
    private var front: Node<T>? = null
    private var rear: Node<T>? = null

    fun enqueue(item: T) {
        val newNode = Node(item)
        if (isEmpty()) {
            front = newNode
            rear = newNode
        } else {
            rear?.next = newNode
            rear = newNode
        }
    }

    fun dequeue(): T? {
        if (isEmpty()) {
            return null
        }
        val item = front!!.data
        front = front!!.next
        if (front == null) {
            rear = null
        }
        return item
    }

    fun peek(): T? {
        return front?.data
    }

    fun isEmpty(): Boolean {
        return front == null
    }

    fun size(): Int {
        var count = 0
        var current = front
        while (current != null) {
            count++
            current = current.next
        }
        return count
    }
}
```

### Explanation:

- **Array Queue:** This implementation uses a circular array to store elements of the queue. The front and rear pointers keep track of the indices of the first and last elements, respectively. The circular array allows efficient usage of memory and avoids unnecessary shifting of elements.

- **Linked List Queue:** Here, we utilize a singly linked list to implement the queue. Nodes are linked together, with each node containing an element and a reference to the next node. The front pointer points to the first node, and the rear pointer points to the last node. Enqueue and dequeue operations are performed by adding nodes at the rear and removing nodes from the front, respectively.

Both implementations provide the same queue functionality but differ in terms of underlying data structure and operations' time complexity. Array-based queues offer constant time complexity for enqueue and dequeue operations, while linked list-based queues provide the same time complexity for enqueue but may have slightly higher overhead due to node creation and traversal. The choice between them depends on factors like expected usage patterns, memory constraints, and performance requirements.

## Comparison between stacks and queues

Let's compare stacks and queues across various aspects:

### 1. Data Structure:

- **Stacks:** Stacks are based on the Last In, First Out (LIFO) principle, where elements are added and removed from the same end, typically referred to as the top.
- **Queues:** Queues follow the First In, First Out (FIFO) principle, where elements are added at one end (rear) and removed from the other end (front).

### 2. Operations:

- **Stacks:** Support operations such as push (to add an element), pop (to remove and return the top element), and peek (to view the top element without removing it).
- **Queues:** Support operations such as enqueue (to add an element to the rear), dequeue (to remove and return the front element), and peek (to view the front element without removing it).

### 3. Time Complexity:

- **Stacks:** Most stack operations (push, pop, peek) have constant time complexity, O(1), assuming an efficient implementation.
- **Queues:** Most queue operations (enqueue, dequeue, peek) also have constant time complexity, O(1), assuming an efficient implementation.

### 4. Applications:

- **Stacks:** Commonly used in scenarios requiring last in, first out processing, such as function call stacks, expression evaluation, undo functionality, and backtracking algorithms.
- **Queues:** Utilized in situations where first in, first out processing is required, such as breadth-first search (BFS) traversal, task scheduling, event handling, and resource allocation.

### 5. Underlying Data Structures:

- **Stacks:** Can be implemented using arrays, linked lists, or dynamic arrays (e.g., ArrayList in Java or ArrayList in Kotlin).
- **Queues:** Can also be implemented using arrays, linked lists, or dynamic arrays, but circular arrays are often preferred to avoid unnecessary shifting of elements.

### 6. Memory Management:

- **Stacks:** Tend to have simpler memory management as elements are added and removed from the same end, leading to less fragmentation.
- **Queues:** May involve more complex memory management, especially in dynamic arrays or linked list implementations, as elements are added and removed from opposite ends.

### 7. Usage Patterns:

- **Stacks:** Suitable for scenarios where elements need to be processed in reverse order of their insertion, or where recursive or nested operations are involved.
- **Queues:** Ideal for situations where elements need to be processed in the order they arrive, or where fairness in resource allocation is crucial.

In summary, while stacks and queues share similarities in terms of their fundamental operations and time complexities, they serve different purposes and are applied in distinct scenarios based on the requirements of the problem at hand. Understanding the characteristics and applications of each data structure is essential for making informed design decisions in software development and algorithm design.
