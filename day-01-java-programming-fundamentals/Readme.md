
## Classes and objects

In Java, classes and objects are fundamental concepts of object-oriented programming (OOP). A class is a blueprint or template for creating objects, while an object is an instance of a class. Classes define the properties (attributes) and behaviors (methods) that objects of that type will have.

### Classes:

A class in Java encapsulates data for the object and defines methods to manipulate that data. It serves as a template for creating objects with similar characteristics and behaviors.

```java
public class Employee {
    // Attributes
    private String name;
    private int age;
    private double salary;

    // Constructor
    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    // Methods
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Salary: $" + salary);
    }
}
```

### Objects:

An object is an instance of a class. It represents a real-world entity with specific attributes and behaviors defined by the class.

```java
public class HRManagementSystem {
    public static void main(String[] args) {
        // Creating objects of the Employee class
        Employee emp1 = new Employee("John Doe", 30, 50000);
        Employee emp2 = new Employee("Jane Smith", 25, 60000);

        // Accessing methods of Employee objects
        emp1.displayInfo();
        emp2.displayInfo();
    }
}
```

Explanation:

- In this example, the `Employee` class represents employees and defines attributes such as name, age, and salary, along with a constructor to initialize these attributes.
- The `displayInfo()` method in the `Employee` class is used to display employee information.
- In the `HRManagementSystem` class, we create objects (`emp1` and `emp2`) of the `Employee` class using the `new` keyword and pass initial values to the constructor.
- We then call the `displayInfo()` method on each object to display their information.

## Constructors

In Java, a constructor is a special type of method that is called when an object of a class is created. It is used to initialize the newly created object and allocate memory for its instance variables. Constructors have the same name as the class and do not have a return type, not even `void`.

### Purpose of Constructors:

1. **Initializing Object State**: Constructors are used to set initial values for the attributes (instance variables) of an object.
2. **Memory Allocation**: Constructors allocate memory for the object on the heap.
3. **Invocation**: Constructors are automatically invoked when an object is created using the `new` keyword.
4. **Overloading**: Like methods, constructors can be overloaded, allowing multiple constructors with different parameter lists within the same class.

### Types of Constructors:

1. **Default Constructor**: If you don't provide any constructors in your class, Java provides a default constructor automatically. It initializes all instance variables to their default values (0, null, false, etc.).

2. **Parameterized Constructor**: A constructor with parameters allows you to pass initial values to the object being created. It's useful when you want to initialize object properties with specific values during object creation.

### Example:

Let's consider a simple class `Car` with instance variables `make` and `model`. We'll define both default and parameterized constructors:

```java
public class Car {
    // Instance variables
    private String make;
    private String model;

    // Default Constructor
    public Car() {
        make = "Unknown";
        model = "Unknown";
    }

    // Parameterized Constructor
    public Car(String make, String model) {
        this.make = make;
        this.model = model;
    }

    // Method to display car information
    public void displayInfo() {
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
    }

    public static void main(String[] args) {
        // Creating objects using constructors
        Car car1 = new Car(); // Default Constructor
        Car car2 = new Car("Toyota", "Camry"); // Parameterized Constructor

        // Displaying car information
        car1.displayInfo();
        car2.displayInfo();
    }
}
```

### Explanation:

- In this example, the `Car` class has two constructors: a default constructor and a parameterized constructor.
- The default constructor initializes the `make` and `model` variables to "Unknown" when no arguments are provided.
- The parameterized constructor allows the caller to specify the `make` and `model` of the car during object creation.
- We create two `Car` objects (`car1` and `car2`) using both constructors and display their information using the `displayInfo()` method.

Constructors play a crucial role in initializing objects in Java and are used to ensure that objects are properly initialized before they are used. They allow for the creation of objects with specific initial states and facilitate the encapsulation of object creation logic within the class itself.

## Method overloading

Method overloading in Java refers to the ability to define multiple methods in a class with the same name but with different parameters. This allows you to use the same method name for different behaviors or functionalities based on the types or number of arguments passed to the method. Method overloading is a form of compile-time polymorphism.

### Rules for Method Overloading:

1. The overloaded methods must have the same name.
2. The overloaded methods must have different parameter lists (number, type, or order of parameters).
3. The return type of the overloaded methods may or may not be the same.
4. Method overloading can occur in the same class or in a subclass, but not within the same method.

### Example:

Let's consider a class `Calculator` with multiple overloaded methods for performing addition:

```java
public class Calculator {
    // Method to add two integers
    public int add(int a, int b) {
        return a + b;
    }

    // Method to add three integers
    public int add(int a, int b, int c) {
        return a + b + c;
    }

    // Method to add two doubles
    public double add(double a, double b) {
        return a + b;
    }

    // Method to concatenate two strings
    public String add(String a, String b) {
        return a + b;
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();

        // Overloaded methods for addition
        System.out.println("Sum of 5 and 10: " + calc.add(5, 10));
        System.out.println("Sum of 5, 10, and 15: " + calc.add(5, 10, 15));
        System.out.println("Sum of 3.5 and 2.5: " + calc.add(3.5, 2.5));
        System.out.println("Concatenated string: " + calc.add("Hello", "World"));
    }
}
```

### Explanation:

- In this example, the `Calculator` class defines multiple `add` methods with different parameter lists.
- There are four overloaded `add` methods:
  1. `add(int a, int b)`: Adds two integers.
  2. `add(int a, int b, int c)`: Adds three integers.
  3. `add(double a, double b)`: Adds two doubles.
  4. `add(String a, String b)`: Concatenates two strings.
- The `main` method creates an instance of `Calculator` and demonstrates calling each overloaded `add` method with different arguments.
- Depending on the number and types of arguments passed, the appropriate overloaded method is invoked.

### Benefits of Method Overloading:

1. Improved Code Readability: Method overloading allows you to use descriptive method names for different behaviors, enhancing code readability.
2. Reduced Redundancy: Instead of defining multiple methods with different names for similar functionalities, you can use method overloading to achieve the same result with a single method name.
3. Flexibility: Method overloading provides flexibility in method design by allowing methods to handle different types and numbers of arguments.

Method overloading is a powerful feature of Java that promotes code reusability and maintainability by allowing you to define multiple methods with the same name but different parameter lists to cater to different requirements.

## Inheritance

Inheritance is a fundamental concept in object-oriented programming (OOP) that allows a class (called a subclass or derived class) to inherit attributes and methods from another class (called a superclass or base class). In Java, inheritance enables code reuse and promotes the concept of hierarchy among classes.

### Concept of Inheritance:

- **Superclass**: The class whose attributes and methods are inherited by another class is called a superclass.
- **Subclass**: The class that inherits attributes and methods from a superclass is called a subclass.

### Implementation of Inheritance in Java:

In Java, inheritance is implemented using the `extends` keyword. A subclass can inherit from only one superclass (single inheritance), but Java supports multiple levels of inheritance.

### Example:

Let's consider an HR management system with a superclass `Employee` and subclasses `Manager` and `Staff`. The `Employee` class defines common attributes and methods for all employees, while the subclasses `Manager` and `Staff` inherit from `Employee` and add specific attributes and methods.

```java
// Superclass
class Employee {
    private String name;
    private double salary;

    // Constructors
    public Employee(){
    }

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    // Method to display employee information
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Salary: $" + salary);
    }
}

// Subclass 1
class Manager extends Employee {
    private String department;

    // Constructors
    public Manager(){
    }

    public Manager(String name, double salary, String department) {
        super(name, salary); // Call superclass constructor
        this.department = department;
    }

    // Method to display manager information
    public void displayInfo() {
        super.displayInfo(); // Call superclass method
        System.out.println("Department: " + department);
    }
}

// Subclass 2
class Staff extends Employee {
    private String designation;

    // Constructors
    public Staff(){
    }

    public Staff(String name, double salary, String designation) {
        super(name, salary); // Call superclass constructor
        this.designation = designation;
    }

    // Method to display staff information
    public void displayInfo() {
        super.displayInfo(); // Call superclass method
        System.out.println("Designation: " + designation);
    }
}

public class HRManagementSystem {
    public static void main(String[] args) {
        // Creating objects of Manager and Staff classes
        Manager manager = new Manager("John Doe", 60000, "Finance");
        Staff staff = new Staff("Jane Smith", 40000, "Software Engineer");

        // Displaying information of manager and staff
        System.out.println("Manager Information:");
        manager.displayInfo();

        System.out.println("\nStaff Information:");
        staff.displayInfo();
    }
}
```

### Explanation:

- In this example, the `Employee` class serves as the superclass, defining common attributes (`name` and `salary`) and methods (`displayInfo`) for all employees.
- The `Manager` class and `Staff` class are subclasses of `Employee`. They inherit attributes and methods from `Employee` and define additional attributes (`department` and `designation`) specific to managers and staff, respectively.
- Both subclasses have their own constructors that call the superclass constructor using the `super` keyword to initialize inherited attributes.
- Each subclass also overrides the `displayInfo` method to provide specific implementations while calling the superclass method using `super.displayInfo()` to reuse common functionality.

### Benefits of Inheritance:

1. Code Reusability: Inheritance promotes code reuse by allowing subclasses to inherit attributes and methods from a superclass, reducing redundant code.
2. Modularity: Inheritance facilitates modular design by organizing classes into a hierarchy, making it easier to manage and maintain the codebase.
3. Polymorphism: Inheritance enables polymorphic behavior, where a subclass object can be treated as an object of its superclass, allowing for flexibility and dynamic behavior.

Inheritance is a powerful mechanism in Java that promotes code reuse, modularity, and polymorphism, making it easier to design and maintain complex systems with hierarchical relationships between classes.

## Method overriding

Method overriding is a feature of object-oriented programming that allows a subclass to provide a specific implementation of a method that is already defined in its superclass. In Java, when a subclass defines a method with the same name, return type, and parameter list as a method in its superclass, it overrides the superclass method.

### Method Overriding in the HR Management System Example:

In the HR management system example provided earlier, both the `Manager` and `Staff` classes override the `displayInfo()` method of the superclass `Employee` to provide specific implementations for displaying manager and staff information, respectively.

```java
// Superclass
class Employee {
    // Other code...

    // Method to display employee information
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Salary: $" + salary);
    }
}

// Subclass 1
class Manager extends Employee {
    // Other code...

    // Method overriding - displays manager information
    @Override
    public void displayInfo() {
        super.displayInfo(); // Call superclass method
        System.out.println("Department: " + department);
    }
}

// Subclass 2
class Staff extends Employee {
    // Other code...

    // Method overriding - displays staff information
    @Override
    public void displayInfo() {
        super.displayInfo(); // Call superclass method
        System.out.println("Designation: " + designation);
    }
}
```

### Explanation:

- Both the `Manager` and `Staff` classes override the `displayInfo()` method of the superclass `Employee`.
- The overriding methods in the subclasses provide specific implementations for displaying manager and staff information, respectively, while still calling the superclass method using `super.displayInfo()`.
- When an object of the `Manager` or `Staff` class invokes the `displayInfo()` method, the overridden method in the respective subclass is executed, providing customized behavior based on the type of employee.

Method overriding allows subclasses to provide their own implementation of methods inherited from a superclass, enabling customization and specialization of behavior while maintaining a consistent interface across related classes.

## Access modifiers in Java

Access modifiers in Java are keywords used to control the visibility and accessibility of classes, methods, and variables within a program. These modifiers determine which parts of a program can access a particular class, method, or variable. Java provides four types of access modifiers:

1. **`public`**: The `public` access modifier makes a class, method, or variable accessible from anywhere in the program, including other packages.

2. **`private`**: The `private` access modifier restricts the visibility of a class member (method or variable) to only within its own class. It cannot be accessed from outside the class.

3. **`protected`**: The `protected` access modifier allows access to the class member within its own package and by subclasses (even if they are in different packages).

4. **`default` (no modifier)**: If no access modifier is specified, the class member has default access, which means it is accessible only within its own package.

## Abstract methods and abstract classes

Abstract methods and abstract classes are key components of object-oriented programming in Java. They allow you to define blueprints for classes and methods without providing implementation details. Abstract classes cannot be instantiated, but they can contain both abstract and concrete methods. Abstract methods are declared without a body and must be implemented by subclasses.

### Abstract Classes:

- An abstract class is a class that cannot be instantiated directly. It serves as a blueprint for other classes to extend from.
- Abstract classes may contain abstract methods, concrete methods, instance variables, and constructors.
- To declare an abstract class, use the `abstract` keyword before the class declaration.

### Abstract Methods:

- An abstract method is a method declared without an implementation.
- Abstract methods are meant to be overridden by subclasses, providing specific implementations.
- Abstract methods are declared using the `abstract` keyword and do not have a method body.

### Example:

Let's create an abstract class `Employee` representing employees in the HR management system. This class will contain an abstract method `calculateSalary()` to calculate the salary of different types of employees. We'll also provide concrete implementations for other methods.

```java
// Abstract class
abstract class Employee {
    // Instance variables
    protected String name;
    protected double baseSalary;

    // Constructor
    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // Abstract method to calculate salary
    public abstract double calculateSalary();

    // Concrete method to display employee information
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Base Salary: $" + baseSalary);
    }
}

// Concrete subclass 1
class Manager extends Employee {
    // Constructor
    public Manager(String name, double baseSalary) {
        super(name, baseSalary);
    }

    // Implementation of abstract method
    @Override
    public double calculateSalary() {
        return baseSalary * 2; // Example calculation for manager's salary
    }
}

// Concrete subclass 2
class Staff extends Employee {
    // Constructor
    public Staff(String name, double baseSalary) {
        super(name, baseSalary);
    }

    // Implementation of abstract method
    @Override
    public double calculateSalary() {
        return baseSalary; // Example calculation for staff's salary
    }
}

// Main class
public class HRManagementSystem {
    public static void main(String[] args) {
        // Creating objects of Manager and Staff classes
        Manager manager = new Manager("John Doe", 50000);
        Staff staff = new Staff("Jane Smith", 30000);

        // Displaying information and salary of manager and staff
        System.out.println("Manager Information:");
        manager.displayInfo();
        System.out.println("Salary: $" + manager.calculateSalary());

        System.out.println("\nStaff Information:");
        staff.displayInfo();
        System.out.println("Salary: $" + staff.calculateSalary());
    }
}
```

### Explanation:

- In this example, the `Employee` class is declared as an abstract class using the `abstract` keyword.
- It contains an abstract method `calculateSalary()` which is declared without an implementation.
- Concrete subclasses `Manager` and `Staff` extend the `Employee` class and provide specific implementations for the `calculateSalary()` method.
- The `main` method demonstrates creating objects of the concrete subclasses and invoking methods to display employee information and calculate salaries.

Abstract classes and methods provide a way to define common behavior and enforce implementation requirements in a hierarchical manner, promoting code reusability and modularity. They are particularly useful in scenarios where you want to define a common interface or behavior that should be implemented by subclasses with specific variations.

## Interfaces in Java

Interfaces in Java define a contract for classes to implement. They provide a way to specify a set of methods that a class must implement, without providing the implementation details. Interfaces are used to achieve abstraction, multiple inheritance, and to establish a common contract among unrelated classes.

### Key Points about Interfaces:

1. **Declaration**: Interfaces are declared using the `interface` keyword followed by the interface name.
2. **Abstract Methods**: Interfaces contain abstract methods that are declared without an implementation.
3. **Constants**: Interfaces can also contain constant fields, which are implicitly `public`, `static`, and `final`.
4. **Multiple Inheritance**: Java allows a class to implement multiple interfaces, enabling a form of multiple inheritance.
5. **Implementation**: Classes implement interfaces using the `implements` keyword, and they must provide concrete implementations for all abstract methods defined in the interface.

### Example:

```java
// Interface representing entities that can be paid
interface Payable {
    // Abstract method
    String payTo();
    double calculatePayment();
}

// Employee class implementing Payable interface
class Employee implements Payable {
    private String name;
    private double salary;

    // Constructor
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    // Implementation of calculatePayment method from Payable interface
    @Override
    public String payTo(){
        return this.name;
    }

    @Override
    public double calculatePayment() {
        return salary;
    }

    // Other methods...
}

// Contractor class implementing Payable interface
class Contractor implements Payable {
    private String name;
    private double hourlyRate;
    private int hoursWorked;

    // Constructor
    public Contractor(String name, double hourlyRate, int hoursWorked) {
        this.name = name;
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    // Implementation of calculatePayment method from Payable interface
    @Override
    public String payTo(){
        return this.name;
    }

    @Override
    public double calculatePayment() {
        return hourlyRate * hoursWorked;
    }

    // Other methods...
}

// Main class
public class HRManagementSystem {
    // Static method to print payment details
    public static void printPaymentDetails(Payable payable) {
        System.out.println("Payment details:");
        System.out.println("Name: " + payable.payTo());
        System.out.println("Payment: $" + payable.calculatePayment());
    }

    public static void main(String[] args) {
        // Creating objects of Employee and Contractor classes
        Employee employee = new Employee("John Doe", 50000);
        Contractor contractor = new Contractor("Jane Smith", 25, 40);

        // Calling printPaymentDetails method to print payment details
        printPaymentDetails(employee);
        printPaymentDetails(contractor);
    }
}
```

### Explanation:

- In this modified example, I've added a static method `printPaymentDetails` in the `HRManagementSystem` class.
- This method takes a `Payable` variable as an argument, allowing it to accept objects of both `Employee` and `Contractor` classes.
- Inside the `printPaymentDetails` method, we use the `calculatePayment()` method of the `Payable` interface to calculate the payment for the passed object.
- The `main` method creates objects of `Employee` and `Contractor` classes and calls the `printPaymentDetails` method to print payment details for each object.

This modification enhances the flexibility and extensibility of the code by centralizing the printing of payment details into a separate method. It also demonstrates the use of interfaces to achieve polymorphic behavior, as the `printPaymentDetails` method can accept any object that implements the `Payable` interface.

## Enumerations and nested classes in Java

Enumerations and nested classes are both important concepts in Java that allow for better organization, encapsulation, and readability of code.

### Enumerations:

Enumerations, also known as enums, are a special type in Java used to define a collection of constants. Enumerations provide a way to represent a fixed set of predefined values, making the code more readable and less error-prone.

#### Declaration:

```java
enum Season {
    WINTER, SPRING, SUMMER, FALL
}
```

#### Usage:

```java
Season currentSeason = Season.WINTER;
System.out.println("Current season is: " + currentSeason);
```

### Nested Classes:

Nested classes are classes defined within another class. They can be static or non-static (also known as inner classes). Nested classes provide a way to logically group classes that are only used in one place, increase encapsulation, and improve code organization.

#### Static Nested Class:

```java
class Outer {
    static class Nested {
        void display() {
            System.out.println("Nested class method");
        }
    }
}
```

#### Inner Class (Non-static Nested Class):

```java
class Outer {
    class Inner {
        void display() {
            System.out.println("Inner class method");
        }
    }
}
```

#### Usage:

```java
Outer.Nested nestedObject = new Outer.Nested();
nestedObject.display();

Outer outerObject = new Outer();
Outer.Inner innerObject = outerObject.new Inner();
innerObject.display();
```

### Example Usage:

Let's say we want to represent different types of employees using enums and define an inner class to handle employee promotions within the `Employee` class.

```java
enum EmployeeType {
    FULL_TIME, PART_TIME, CONTRACTOR
}

class Employee {
    private String name;
    private double salary;
    private EmployeeType type;

    public Employee(String name, double salary, EmployeeType type) {
        this.name = name;
        this.salary = salary;
        this.type = type;
    }

    public void promote() {
        if (type == EmployeeType.FULL_TIME) {
            // Perform promotion for full-time employees
            System.out.println(name + " has been promoted!");
        } else {
            System.out.println("Promotion not applicable for " + type + " employees.");
        }
    }
}
```

### Explanation:

- Enumerations provide a way to represent fixed sets of constants, such as seasons, days of the week, etc.
- Nested classes allow classes to be defined within another class, improving code organization and encapsulation.
- Static nested classes are associated with the enclosing class and can be instantiated independently.
- Inner classes are non-static nested classes and have access to the instance variables and methods of the enclosing class.
- In the HR management system example, `EmployeeType` enum represents different types of employees, and the `Employee` class contains an inner method `promote()` to handle promotions based on employee type.

Both enumerations and nested classes are powerful features in Java that contribute to better code organization, encapsulation, and maintainability. They are widely used in Java programming to improve readability and reduce complexity.
