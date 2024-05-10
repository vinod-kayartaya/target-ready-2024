# Control Flow, Functions

## Conditional statements (if, else, when)

Conditional statements such as `if`, `else`, and `when` are crucial for controlling the flow of execution in Kotlin programs. They allow you to execute certain blocks of code based on specified conditions. Let's explore how these conditional statements work:

### 1. `if` Statement:

The `if` statement is used to execute a block of code if a specified condition is true.

```kotlin
val x = 10

if (x > 5) {
    println("x is greater than 5")
}
```

### 2. `if-else` Statement:

The `if-else` statement is used to execute one block of code if the condition is true and another block if the condition is false.

```kotlin
val x = 10

if (x > 5) {
    println("x is greater than 5")
} else {
    println("x is less than or equal to 5")
}
```

### 3. `if-else-if` Ladder:

You can use multiple `else-if` blocks to handle multiple conditions sequentially.

```kotlin
val x = 10

if (x > 10) {
    println("x is greater than 10")
} else if (x == 10) {
    println("x is equal to 10")
} else {
    println("x is less than 10")
}
```

### 4. `when` Expression:

The `when` expression is Kotlin's replacement for the traditional `switch` statement in Java. It allows you to check a value against multiple cases and execute corresponding code blocks.

```kotlin
val dayOfWeek = 3

when (dayOfWeek) {
    1 -> println("Monday")
    2 -> println("Tuesday")
    3 -> println("Wednesday")
    4 -> println("Thursday")
    5 -> println("Friday")
    6 -> println("Saturday")
    7 -> println("Sunday")
    else -> println("Invalid day")
}
```

### 5. `when` with Multiple Values:

You can use `when` with multiple values separated by commas to execute the same code block for multiple cases.

```kotlin
val x = 5

when (x) {
    1, 2, 3 -> println("x is between 1 and 3")
    4, 5, 6 -> println("x is between 4 and 6")
    else -> println("x is not between 1 and 6")
}
```

### 6. `when` with Conditions:

You can also use arbitrary conditions in `when` expressions.

```kotlin
val x = 10

when {
    x < 0 -> println("x is negative")
    x == 0 -> println("x is zero")
    x > 0 -> println("x is positive")
}
```

### 7. `when` as an Expression:

`when` can also be used as an expression, allowing you to assign its result to a variable.

```kotlin
val dayOfWeek = 3
val dayName = when (dayOfWeek) {
    1 -> "Monday"
    2 -> "Tuesday"
    3 -> "Wednesday"
    4 -> "Thursday"
    5 -> "Friday"
    6 -> "Saturday"
    7 -> "Sunday"
    else -> "Invalid day"
}

println("Today is $dayName")
```

Conditional statements like `if`, `else`, and `when` are indispensable tools for controlling program flow and making decisions based on different conditions in Kotlin. Understanding how to use them effectively will empower you to write more flexible and powerful Kotlin code.

## Looping constructs (for, while, do-while)

Looping constructs such as `for`, `while`, and `do-while` are essential for iterating over collections, executing code repeatedly, and controlling program flow based on certain conditions in Kotlin. Let's explore how these looping constructs work:

### 1. `for` Loop:

The `for` loop is used to iterate over ranges, arrays, collections, or any other iterable objects.

#### Iterate over a Range:

```kotlin
for (i in 1..5) {
    println(i)
}
```

#### Iterate over an Array:

```kotlin
val numbers = arrayOf(1, 2, 3, 4, 5)

for (number in numbers) {
    println(number)
}
```

#### Iterate over a Collection:

```kotlin
val names = listOf("Alice", "Bob", "Charlie")

for (name in names) {
    println(name)
}
```

#### Using Index in `for` Loop:

```kotlin
val numbers = arrayOf(1, 2, 3, 4, 5)

for (index in numbers.indices) {
    println("Index: $index, Value: ${numbers[index]}")
}
```

### 2. `while` Loop:

The `while` loop is used to execute a block of code repeatedly as long as a specified condition is true.

```kotlin
var x = 0

while (x < 5) {
    println(x)
    x++
}
```

### 3. `do-while` Loop:

The `do-while` loop is similar to the `while` loop, but the condition is checked after the execution of the block, so the block is always executed at least once.

```kotlin
var x = 0

do {
    println(x)
    x++
} while (x < 5)
```

### Loop Control Statements:

Kotlin also supports loop control statements to alter the flow of loop execution:

1. **`break` Statement**:

   - Terminates the loop immediately.

   ```kotlin
   for (i in 1..10) {
       if (i == 5) {
           break
       }
       println(i)
   }
   ```

2. **`continue` Statement**:

   - Skips the current iteration of the loop and continues with the next iteration.

   ```kotlin
   for (i in 1..10) {
       if (i % 2 == 0) {
           continue
       }
       println(i)
   }
   ```

3. **Loop Labels**:
   - Allows you to specify which loop to break or continue in nested loops.
   ```kotlin
   outer@ for (i in 1..5) {
       inner@ for (j in 1..3) {
           if (i == 3 && j == 2) {
               break@outer
           }
           println("i: $i, j: $j")
       }
   }
   ```

### Iterating Over Map Entries:

Kotlin provides a convenient way to iterate over map entries using the `for` loop:

```kotlin
val map = mapOf("A" to 1, "B" to 2, "C" to 3)

for ((key, value) in map) {
    println("$key -> $value")
}
```

Looping constructs are powerful tools for controlling the flow of execution and iterating over data structures in Kotlin. Understanding how to use `for`, `while`, and `do-while` loops effectively will enable you to write more efficient and concise Kotlin code.

## Introduction to functions in Kotlin

Functions in Kotlin are a fundamental building block of any program. They encapsulate a set of instructions that perform a specific task and can be called multiple times from different parts of the program. Kotlin provides various features for defining, calling, and working with functions. Let's explore the basics of functions in Kotlin:

### 1. Function Declaration:

In Kotlin, functions are declared using the `fun` keyword followed by the function name, parameters (if any), return type (if any), and body enclosed in curly braces `{}`.

```kotlin
fun greet() {
    println("Hello, Kotlin!")
}
```

### 2. Function Parameters:

Functions can take parameters, which are values passed to the function when it is called. Parameters are declared inside parentheses `()` after the function name.

```kotlin
fun greet(name: String) {
    println("Hello, $name!")
}
```

### 3. Return Types:

Functions can return a value using the `return` keyword. If a function does not return any value, its return type is `Unit` (similar to `void` in Java).

```kotlin
fun add(a: Int, b: Int): Int {
    return a + b
}
```

### 4. Calling Functions:

Functions are called by using their name followed by parentheses `()`. If the function takes parameters, the values are passed inside the parentheses.

```kotlin
greet()  // Output: Hello, Kotlin!

val result = add(3, 5)
println("Result: $result")  // Output: Result: 8
```

### 5. Default Parameter Values:

You can provide default values for function parameters. If a value is not passed for a parameter, the default value will be used.

```kotlin
fun greet(name: String = "Kotlin") {
    println("Hello, $name!")
}

greet()  // Output: Hello, Kotlin!
greet("Alice")  // Output: Hello, Alice!
```

### 6. Named Arguments:

In Kotlin, you can use named arguments to improve the readability of function calls, especially when a function has multiple parameters.

```kotlin
fun greet(greeting: String, name: String) {
    println("$greeting, $name!")
}

greet(name = "Alice", greeting = "Hi")  // Output: Hi, Alice!
```

### 7. Single-Expression Functions:

If a function consists of a single expression, you can define it concisely using the shorthand syntax.

```kotlin
fun square(x: Int): Int = x * x
```

### 8. Function Scope:

Functions in Kotlin can be declared at the top level of a file, within a class, or even inside another function (local functions).

### 9. Recursive Functions:

Kotlin supports recursive functions, which are functions that call themselves.

```kotlin
fun factorial(n: Int): Int {
    return if (n == 0) 1 else n * factorial(n - 1)
}
```

### 10. Higher-Order Functions:

Kotlin supports higher-order functions, which are functions that can accept other functions as parameters or return functions as results.

```kotlin
fun operate(x: Int, y: Int, operation: (Int, Int) -> Int): Int {
    return operation(x, y)
}

val result = operate(3, 5) { a, b -> a + b }  // Result: 8
```

Functions are a fundamental aspect of Kotlin programming, allowing you to encapsulate logic, promote reusability, and improve code organization. Understanding how to define, call, and work with functions effectively is essential for writing Kotlin programs.

## Function declaration and invocation

In Kotlin, functions are declared using the `fun` keyword followed by the function name, parameters (if any), return type (if any), and the function body enclosed in curly braces `{}`. Let's look at how to declare and invoke functions in Kotlin:

### Function Declaration:

#### Basic Function:

```kotlin
fun greet() {
    println("Hello, Kotlin!")
}
```

#### Function with Parameters:

```kotlin
fun greet(name: String) {
    println("Hello, $name!")
}
```

#### Function with Return Type:

```kotlin
fun add(a: Int, b: Int): Int {
    return a + b
}
```

#### Function with Default Parameter Value:

```kotlin
fun greet(name: String = "Kotlin") {
    println("Hello, $name!")
}
```

#### Single-Expression Function:

```kotlin
fun square(x: Int): Int = x * x
```

### Function Invocation:

#### Calling a Function without Parameters:

```kotlin
greet() // Output: Hello, Kotlin!
```

#### Calling a Function with Parameters:

```kotlin
greet("Alice") // Output: Hello, Alice!
```

#### Calling a Function with Return Value:

```kotlin
val result = add(3, 5)
println("Result: $result") // Output: Result: 8
```

#### Calling a Function with Named Arguments:

```kotlin
greet(name = "Alice") // Output: Hello, Alice!
```

#### Using Default Parameter Value:

```kotlin
greet() // Output: Hello, Kotlin!
greet("Bob") // Output: Hello, Bob!
```

#### Invoking Single-Expression Function:

```kotlin
val squared = square(5)
println("Squared: $squared") // Output: Squared: 25
```

Understanding function declaration and invocation is crucial for writing Kotlin programs. Functions allow you to encapsulate reusable logic and improve code readability. By mastering function declaration and invocation, you can write modular and maintainable Kotlin code efficiently.

## Parameters and return types

In Kotlin, functions can have parameters and return types, which allow them to accept input values, perform operations on those values, and optionally return a result. Let's explore how parameters and return types are defined in Kotlin functions:

### Parameters:

Parameters are specified within the parentheses `()` after the function name. They define the input values that the function expects when it is called.

#### Syntax:

```kotlin
fun functionName(param1: Type1, param2: Type2, ...) {
    // Function body
}
```

#### Example:

```kotlin
fun greet(name: String) {
    println("Hello, $name!")
}
```

### Return Types:

Return types specify the type of value that a function returns after performing its operations. If a function does not return any value, its return type is `Unit`, similar to `void` in other languages.

#### Syntax:

```kotlin
fun functionName(param1: Type1, param2: Type2, ...): ReturnType {
    // Function body
    return returnValue
}
```

#### Example:

```kotlin
fun add(a: Int, b: Int): Int {
    return a + b
}
```

### Function with No Return Type (Unit):

If a function does not return any meaningful value, its return type can be omitted, or explicitly specified as `Unit`. `Unit` is Kotlin's equivalent of `void` in Java.

#### Example (No Return Type Specified):

```kotlin
fun displayMessage(message: String) {
    println(message)
}
```

#### Example (Return Type Explicitly Specified as Unit):

```kotlin
fun displayMessage(message: String): Unit {
    println(message)
}
```

### Functions with Default Parameters:

In Kotlin, you can specify default values for function parameters. If a value is not provided for a parameter when calling the function, the default value will be used.

#### Syntax:

```kotlin
fun functionName(param1: Type1 = defaultValue1, param2: Type2 = defaultValue2, ...) {
    // Function body
}
```

#### Example:

```kotlin
fun greet(name: String = "Kotlin") {
    println("Hello, $name!")
}
```

### Using Named Arguments:

Kotlin supports named arguments, allowing you to specify arguments by parameter name, which can improve readability, especially for functions with multiple parameters.

#### Example:

```kotlin
fun greet(greeting: String, name: String) {
    println("$greeting, $name!")
}

greet(name = "Alice", greeting = "Hi") // Output: Hi, Alice!
```

Understanding how to define functions with parameters and return types is essential for writing Kotlin programs. Parameters allow functions to accept input values, while return types specify the type of value returned by the function. By leveraging parameters and return types effectively, you can create modular and reusable functions to build robust Kotlin applications.

## Scope and visibility of variables

In Kotlin, the scope and visibility of variables determine where they can be accessed and modified within a program. Kotlin provides several modifiers to control the visibility of variables, ensuring encapsulation and data protection. Let's explore the concepts of scope and visibility in Kotlin:

### 1. Scope:

The scope of a variable refers to the portion of the code where the variable is accessible. Variables can have different scopes depending on where they are declared.

#### Example:

```kotlin
fun main() {
    val x = 10 // x is accessible within the main function
    println(x)

    if (true) {
        val y = 20 // y is accessible only within the if block
        println(y)
    }

    // println(y) // Error: Unresolved reference 'y'
}
```

In this example, `x` is accessible throughout the `main` function, while `y` is accessible only within the `if` block.

### 2. Visibility Modifiers:

Kotlin provides visibility modifiers to control the visibility of variables and functions within classes, packages, and modules. These modifiers help enforce encapsulation and prevent unauthorized access to data.

#### 1. Public (`public`):

- The default visibility modifier in Kotlin.
- Public elements are accessible from anywhere in the same module or from other modules that import the module containing the public element.

#### 2. Private (`private`):

- Private elements are accessible only within the file containing their declaration.
- They are not visible from outside the file, even in nested classes.

#### 3. Protected (`protected`):

- Protected elements are accessible within the same class and its subclasses (inherited classes).
- They are not visible from outside the class hierarchy.

#### 4. Internal (`internal`):

- Internal elements are accessible within the same module.
- They are not visible from outside the module, even if they are in the same package.

#### Example:

```kotlin
// File: Example.kt

package com.example

class Example {
    public val publicVariable = 10
    private val privateVariable = 20
    protected val protectedVariable = 30
    internal val internalVariable = 40

    fun test() {
        println(publicVariable) // Accessible
        println(privateVariable) // Accessible within the same file
        println(protectedVariable) // Accessible within the same class and subclasses
        println(internalVariable) // Accessible within the same module
    }
}

fun main() {
    val obj = Example()
    println(obj.publicVariable) // Accessible
    // println(obj.privateVariable) // Error: Cannot access 'privateVariable': it is private in 'Example'
    // println(obj.protectedVariable) // Error: Cannot access 'protectedVariable': it is protected in 'Example'
    println(obj.internalVariable) // Accessible within the same module
}
```

Understanding the scope and visibility of variables in Kotlin is crucial for writing well-structured and maintainable code. By controlling the visibility of variables using visibility modifiers, you can ensure data protection and encapsulation, which are essential principles of object-oriented programming.
