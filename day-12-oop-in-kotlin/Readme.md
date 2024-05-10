# OOP in Kotlin

## Introduction to object-oriented programming concepts

Object-oriented programming (OOP) is a programming paradigm based on the concept of "objects," which can contain data (attributes) and code (methods). OOP aims to structure code in a

modular and reusable way by organizing it around objects that represent real-world entities or abstract concepts. Here are some key concepts of object-oriented programming:

### 1. Class:

A class is a blueprint or template for creating objects. It defines the properties (attributes) and behaviors (methods) that objects of the class will have.

```kotlin
class Person {
    var name: String = ""
    var age: Int = 0

    fun speak() {
        println("Hello, my name is $name")
    }
}
```

### 2. Object:

An object is an instance of a class. It represents a specific entity or instance in memory that has its own state (attributes) and behavior (methods).

```kotlin
val person1 = Person()
person1.name = "Alice"
person1.age = 30
person1.speak() // Output: Hello, my name is Alice
```

### 3. Encapsulation:

Encapsulation is the bundling of data (attributes) and methods (behaviors) within a class. It hides the internal state of an object and restricts direct access to it, providing controlled access through methods.

```kotlin
class Person {
    private var name: String = ""

    fun setName(newName: String) {
        name = newName
    }

    fun getName(): String {
        return name
    }
}
```

### 4. Inheritance:

Inheritance is a mechanism where a class (subclass) can inherit properties and behaviors from another class (superclass). It promotes code reuse and allows for the creation of a hierarchy of classes.

```kotlin
open class Animal {
    open fun sound() {
        println("Animal makes a sound")
    }
}

class Dog : Animal() {
    override fun sound() {
        println("Dog barks")
    }
}
```

### 5. Polymorphism:

Polymorphism allows objects of different classes to be treated as objects of a common superclass. It enables methods to behave differently based on the object they are called on, facilitating flexibility and extensibility.

```kotlin
fun makeSound(animal: Animal) {
    animal.sound()
}

val animal = Animal()
val dog = Dog()

makeSound(animal) // Output: Animal makes a sound
makeSound(dog) // Output: Dog barks
```

### 6. Abstraction:

Abstraction involves focusing on essential features while hiding unnecessary details. Abstract classes and interfaces allow you to define a blueprint for classes without specifying implementation details, promoting modularity and maintainability.

```kotlin
abstract class Shape {
    abstract fun area(): Double
}

class Rectangle(val width: Double, val height: Double) : Shape() {
    override fun area(): Double {
        return width * height
    }
}
```

### 7. Association, Aggregation, and Composition:

These are ways to model relationships between classes:

- **Association:** A relationship between two classes where one class uses the functionality of another class.
- **Aggregation:** A form of association where one class "has-a" relationship with another class, but the objects can exist independently.
- **Composition:** A stronger form of aggregation where one class "owns" the objects of another class, and the objects cannot exist without the owning class.

Understanding and applying these object-oriented programming concepts enable developers to write modular, maintainable, and scalable code. By designing software around objects and their interactions, OOP promotes code reusability, extensibility, and flexibility.

## Classes and objects in Kotlin

In Kotlin, classes are used to create blueprints for objects. Objects, on the other hand, are instances of classes. Let's delve into the syntax and usage of classes and objects in Kotlin:

### 1. Class Declaration:

You can declare a class using the `class` keyword followed by the class name and its body, which contains properties and methods.

```kotlin
class Person {
    var name: String = ""
    var age: Int = 0

    fun speak() {
        println("Hello, my name is $name")
    }
}
```

### 2. Object Creation:

To create an object from a class, you simply use the class name followed by parentheses `()`. You can then access properties and methods of the object using the dot notation.

```kotlin
val person1 = Person()
person1.name = "Alice"
person1.age = 30
person1.speak() // Output: Hello, my name is Alice
```

### 3. Constructor:

In Kotlin, you can define a primary constructor directly in the class header. Primary constructors can include parameters, which can be used to initialize properties of the class.

```kotlin
class Person(val name: String, var age: Int) {
    fun speak() {
        println("Hello, my name is $name")
    }
}
```

When you declare properties in the primary constructor, Kotlin automatically generates getters and setters for them.

### 4. Secondary Constructors:

You can also define secondary constructors in Kotlin using the `constructor` keyword. Secondary constructors must delegate to the primary constructor using the `this` keyword.

```kotlin
class Person {
    var name: String = ""
    var age: Int = 0

    constructor(name: String, age: Int) {
        this.name = name
        this.age = age
    }
}
```

### 5. Data Classes:

Kotlin provides data classes for creating classes whose main purpose is to hold data. Data classes automatically generate `equals()`, `hashCode()`, `toString()`, and `copy()` methods based on the properties declared in the primary constructor.

```kotlin
data class User(val name: String, val age: Int)
```

### 6. Companion Objects:

Companion objects are objects declared within a class that can be accessed without creating an instance of the class. They are similar to static members in other programming languages.

```kotlin
class MyClass {
    companion object {
        fun create(): MyClass = MyClass()
    }
}

val obj = MyClass.create()
```

### 7. Object Declarations:

Object declarations allow you to define singletons in Kotlin. They are created lazily upon first access and are thread-safe by default.

```kotlin
object MySingleton {
    fun doSomething() {
        println("Doing something...")
    }
}

MySingleton.doSomething() // Output: Doing something...
```

Classes and objects are fundamental concepts in object-oriented programming, enabling you to create reusable and modular code in Kotlin. By defining classes with properties and methods, and creating objects from those classes, you can model real-world entities and implement various functionalities in your Kotlin applications.

## Properties and methods

In Kotlin, properties and methods are fundamental components of classes. They encapsulate the state and behavior of objects. Let's explore properties and methods in more detail:

### Properties:

Properties represent the state or characteristics of an object. They are declared using either `val` (read-only) or `var` (mutable) keywords. Properties can have default values and can be initialized in the primary constructor or in an initializer block.

#### Read-Only Property:

```kotlin
class Person(val name: String) {
    // Read-only property initialized in the primary constructor
}
```

#### Mutable Property:

```kotlin
class Car {
    var brand: String = "" // Mutable property with default value
}
```

#### Late-Initialized Property:

```kotlin
class MyClass {
    lateinit var lateInitProperty: String // Late-initialized mutable property
}
```

### Methods:

Methods represent the behavior or actions that objects can perform. They are defined within a class and can access the properties of the class. Methods can have parameters and return types.

#### Method with Parameters and Return Type:

```kotlin
class Calculator {
    fun add(a: Int, b: Int): Int {
        return a + b
    }
}
```

#### Method with Default Parameter:

```kotlin
class Person {
    fun greet(name: String = "Kotlin") {
        println("Hello, $name!")
    }
}
```

#### Method with Unit Return Type (Equivalent to void):

```kotlin
class Printer {
    fun printMessage(message: String): Unit {
        println(message)
    }
}
```

### Access Modifiers:

Kotlin provides access modifiers to control the visibility of properties and methods:

- `public`: Accessible from anywhere.
- `private`: Accessible only within the same class.
- `protected`: Accessible within the same class and its subclasses.
- `internal`: Accessible within the same module.

#### Example:

```kotlin
class MyClass {
    private var privateProperty: Int = 0

    private fun privateMethod() {
        // Can only be called from within the same class
    }
}
```

### Getters and Setters:

Kotlin automatically generates getters and setters for properties unless they are declared as `private` or `internal`. You can customize the behavior of getters and setters if needed.

#### Example:

```kotlin
class Person {
    var age: Int = 0
        set(value) {
            if (value >= 0) {
                field = value
            }
        }
}
```

### Companion Objects:

Companion objects are associated with the class rather than instances of the class. They are used to define static methods and properties.

#### Example:

```kotlin
class MyClass {
    companion object {
        fun create(): MyClass {
            return MyClass()
        }
    }
}

val obj = MyClass.create()
```

Properties and methods are essential components of classes in Kotlin. They encapsulate the state and behavior of objects, allowing you to model real-world entities and implement various functionalities in your Kotlin applications. Understanding how to define and use properties and methods effectively is crucial for writing object-oriented and modular Kotlin code.

## Constructors and initialization

In Kotlin, constructors are special functions that are called when an object is created. They are used to initialize the properties of the object. Kotlin provides primary constructors and secondary constructors, along with initialization blocks, to facilitate object initialization. Let's explore constructors and initialization in more detail:

### 1. Primary Constructor:

The primary constructor is declared in the class header. It initializes the properties of the class. Properties declared in the primary constructor can also be declared directly in the class body.

#### Example 1: Primary Constructor with Properties:

```kotlin
class Person(val name: String, var age: Int) {
    // Properties initialized in the primary constructor
}
```

#### Example 2: Primary Constructor with Initialization Block:

```kotlin
class Person(val name: String, var age: Int) {
    init {
        println("Initialized: $name, $age")
    }
}
```

### 2. Secondary Constructor:

Secondary constructors are prefixed with the `constructor` keyword and are defined in the class body. They can be used to provide additional initialization logic or to provide alternative ways to create objects.

#### Example: Secondary Constructor:

```kotlin
class Person {
    var name: String = ""
    var age: Int = 0

    constructor(name: String, age: Int) {
        this.name = name
        this.age = age
    }
}
```

### 3. Initialization Blocks:

Initialization blocks are code blocks that are executed when an object is created. They are declared using the `init` keyword and are executed after the primary constructor.

#### Example: Initialization Block:

```kotlin
class Person(val name: String, var age: Int) {
    init {
        println("Initialized: $name, $age")
    }
}
```

### 4. Property Initialization:

Properties can be initialized directly in the class body or in the primary constructor. Properties initialized in the primary constructor can also have default values.

#### Example: Property Initialization:

```kotlin
class Person(val name: String = "John", var age: Int = 30) {
    // Properties initialized with default values in the primary constructor
}
```

### 5. Late-Initialized Properties:

Properties declared as `lateinit` are initialized at a later point, allowing you to defer initialization until it is necessary. `lateinit` properties must be of a non-null type and cannot be of a primitive type.

#### Example: Late-Initialized Property:

```kotlin
class MyClass {
    lateinit var lateInitProperty: String
}
```

### 6. Lazy Initialization:

Properties can be lazily initialized using the `lazy` delegate. The initialization value will be computed only when the property is accessed for the first time.

#### Example: Lazy Initialization:

```kotlin
class MyClass {
    val lazyProperty: String by lazy {
        println("Initializing lazy property")
        "Lazy Initialized Value"
    }
}
```

Constructors and initialization play a crucial role in object creation and initialization in Kotlin. Whether you're using primary constructors, secondary constructors, initialization blocks, or property initialization, understanding how to effectively initialize objects ensures that your Kotlin code is clean, concise, and maintainable.

## Inheritance and polymorphism

Inheritance and polymorphism are key concepts in object-oriented programming (OOP) that enable code reuse, extensibility, and flexibility. Let's explore these concepts in Kotlin:

### Inheritance:

Inheritance is a mechanism where a class (subclass) can inherit properties and behaviors from another class (superclass). It promotes code reuse and allows for the creation of a hierarchy of classes.

#### Syntax:

```kotlin
open class Superclass {
    // Superclass properties and methods
}

class Subclass : Superclass() {
    // Subclass properties and methods
}
```

#### Example:

```kotlin
open class Animal(val species: String) {
    fun makeSound() {
        println("Animal makes a sound")
    }
}

class Dog : Animal("Canine") {
    fun bark() {
        println("Dog barks")
    }
}

val dog = Dog()
println(dog.species) // Output: Canine
dog.makeSound() // Output: Animal makes a sound
dog.bark() // Output: Dog barks
```

### Polymorphism:

Polymorphism allows objects of different classes to be treated as objects of a common superclass. It enables methods to behave differently based on the object they are called on.

#### Example:

```kotlin
open class Shape {
    open fun area(): Double {
        return 0.0
    }
}

class Rectangle(val width: Double, val height: Double) : Shape() {
    override fun area(): Double {
        return width * height
    }
}

class Circle(val radius: Double) : Shape() {
    override fun area(): Double {
        return Math.PI * radius * radius
    }
}

fun printArea(shape: Shape) {
    println("Area: ${shape.area()}")
}

val rectangle = Rectangle(5.0, 3.0)
val circle = Circle(2.0)

printArea(rectangle) // Output: Area: 15.0
printArea(circle) // Output: Area: 12.566370614359172
```

In the above example, the `printArea` function accepts an object of the `Shape` superclass. Even though it's called with objects of `Rectangle` and `Circle` subclasses, the `area()` method is polymorphic and behaves differently based on the actual object type.

Inheritance and polymorphism are powerful concepts in object-oriented programming that allow for code reuse, extensibility, and flexibility. By creating class hierarchies and leveraging polymorphic behavior, you can design more modular, maintainable, and scalable Kotlin applications. Understanding how to effectively use inheritance and polymorphism enables you to write cleaner and more efficient code.

## Interfaces and abstract classes

Interfaces and abstract classes are key concepts in object-oriented programming that facilitate code organization, modularity, and polymorphism. In Kotlin, both interfaces and abstract classes provide a way to define contracts for classes, but they have some differences in their usage and implementation. Let's explore interfaces and abstract classes in Kotlin:

### Interfaces:

Interfaces define a contract that classes can implement. They specify a set of methods (without implementation) that classes must provide. Interfaces support multiple inheritance, allowing classes to implement multiple interfaces.

#### Syntax:

```kotlin
interface MyInterface {
    fun method1()
    fun method2()
}
```

#### Example:

```kotlin
interface Animal {
    fun makeSound()
}

class Dog : Animal {
    override fun makeSound() {
        println("Woof!")
    }
}

class Cat : Animal {
    override fun makeSound() {
        println("Meow!")
    }
}

val dog = Dog()
val cat = Cat()

dog.makeSound() // Output: Woof!
cat.makeSound() // Output: Meow!
```

### Abstract Classes:

Abstract classes are similar to interfaces but can also contain methods with implementations. They define a blueprint for other classes to extend. Abstract classes can have both abstract and concrete methods.

#### Syntax:

```kotlin
abstract class MyBaseClass {
    abstract fun abstractMethod()
    fun concreteMethod() {
        println("Concrete method implementation")
    }
}
```

#### Example:

```kotlin
abstract class Shape {
    abstract fun area(): Double
    abstract fun perimeter(): Double
}

class Rectangle(val width: Double, val height: Double) : Shape() {
    override fun area(): Double {
        return width * height
    }

    override fun perimeter(): Double {
        return 2 * (width + height)
    }
}

val rectangle = Rectangle(5.0, 3.0)
println("Area: ${rectangle.area()}") // Output: Area: 15.0
println("Perimeter: ${rectangle.perimeter()}") // Output: Perimeter: 16.0
```

### Differences and Use Cases:

- **Interfaces**:

  - Specify a contract for classes to implement.
  - Cannot contain state or concrete method implementations.
  - Support multiple inheritance.
  - Suitable for defining capabilities or behaviors that classes should have.

- **Abstract Classes**:
  - Provide a partially implemented class with both abstract and concrete methods.
  - Can contain state and method implementations.
  - Support single inheritance.
  - Suitable for defining common behavior among closely related classes.

Interfaces and abstract classes are important tools for defining contracts and common behavior in Kotlin. By understanding their differences and use cases, you can effectively design modular, maintainable, and extensible Kotlin code. Choosing between interfaces and abstract classes depends on the specific requirements and design goals of your application.
