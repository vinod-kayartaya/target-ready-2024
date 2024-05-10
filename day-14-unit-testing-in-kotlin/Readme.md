# Unit testing in Kotlin

## Understanding the purpose and importance of unit testing

Unit testing is a critical practice in software development that involves testing individual units or components of code in isolation to ensure they function correctly. These units can be functions, methods, classes, or even entire modules. Unit testing is essential for several reasons:

### Purpose of Unit Testing:

1. **Identifying Bugs Early**: Unit tests help identify bugs and issues in code early in the development process, making them cheaper and easier to fix.

2. **Maintaining Code Quality**: Unit tests act as a safety net, ensuring that changes to the codebase don't introduce new bugs or regressions.

3. **Improving Code Design**: Writing unit tests often leads to more modular and testable code, as it encourages separation of concerns and adherence to SOLID principles.

4. **Facilitating Refactoring**: Unit tests provide confidence when refactoring code, allowing developers to make changes without fear of breaking existing functionality.

5. **Supporting Documentation**: Unit tests serve as executable documentation, describing how the code is intended to behave and providing usage examples.

### Importance of Unit Testing:

1. **Ensuring Correctness**: Unit tests verify that individual units of code behave as expected under various conditions, ensuring correctness and reliability.

2. **Encouraging Modularity**: Unit testing promotes modular design by focusing on testing individual units in isolation, which leads to cleaner and more maintainable code.

3. **Enhancing Confidence**: Unit tests provide developers with confidence that their code works as intended, allowing them to make changes and add new features without fear of introducing bugs.

4. **Enabling Continuous Integration**: Unit tests are a crucial part of a continuous integration (CI) pipeline, allowing automated testing to be performed on code changes, ensuring that only working code is integrated into the codebase.

5. **Reducing Debugging Time**: Unit tests help narrow down the scope of bugs, making it easier and faster to identify and fix issues during development.

6. **Facilitating Collaboration**: Unit tests serve as executable specifications that describe the behavior of code units, making it easier for developers to collaborate and understand each other's code.

Unit testing plays a vital role in ensuring the quality, reliability, and maintainability of software applications. By testing individual units of code in isolation, developers can catch bugs early, maintain code quality, and facilitate collaboration and continuous integration. Investing time in writing comprehensive unit tests leads to more robust and stable software products in the long run.

## Basic concepts: test cases, assertions, test suites

Let's delve into the basic concepts of unit testing in Kotlin: test cases, assertions, and test suites.

### Test Cases

A test case is a fundamental concept in unit testing. It represents a single, discrete scenario that is tested within your code. In Kotlin, test cases are typically written using a testing framework like JUnit, TestNG, or KotlinTest. Each test case typically follows a similar structure:

1. **Setup**: This is where you prepare the necessary environment for the test case, including creating objects, setting up dependencies, and initializing variables.

2. **Execution**: In this phase, you execute the specific functionality or method that you want to test. This involves calling the method or function with specific inputs or parameters.

3. **Assertion**: After the execution phase, you verify the expected outcome or behavior of the code under test. This is done by using assertions to compare the actual result with the expected result.

4. **Teardown**: Optionally, you may have teardown steps to clean up resources or reset the environment after the test case has been executed. This ensures that each test case is independent of others and doesn't leave any side effects.

Example of a test case in Kotlin using JUnit:

```kotlin
import org.junit.Test
import org.junit.Assert.assertEquals

class MyTestClass {

    @Test
    fun `test addition`() {
        // Setup
        val calculator = Calculator()

        // Execution
        val result = calculator.add(2, 3)

        // Assertion
        assertEquals(5, result)

        // Teardown (not necessary in this example)
    }
}
```

### Assertions

Assertions are statements within your test cases that verify whether a certain condition holds true or not. They are used to validate the behavior or output of the code under test. In Kotlin, common assertion functions are provided by testing frameworks such as JUnit or KotlinTest.

Some common assertion functions include:

- `assertEquals(expected, actual)`: Checks if the expected value is equal to the actual value.
- `assertTrue(condition)`: Checks if the given condition is true.
- `assertFalse(condition)`: Checks if the given condition is false.
- `assertNotNull(value)`: Checks if the given value is not null.
- `assertNull(value)`: Checks if the given value is null.
- `assertSame(expected, actual)`: Checks if the expected and actual objects reference the same object in memory.
- `assertNotSame(expected, actual)`: Checks if the expected and actual objects reference different objects in memory.

These assertion functions help ensure that the code behaves as expected and detects any deviations from the desired behavior.

### Test Suites

A test suite is a collection of test cases that are grouped together for execution. It allows you to organize and run multiple test cases simultaneously. Test suites help in efficiently managing and executing tests, especially when dealing with large codebases or complex systems.

In Kotlin, test suites are typically created using test classes or test functions provided by testing frameworks like JUnit or KotlinTest. You can organize test cases into logical groups based on functionality, modules, or classes.

Example of a test suite in Kotlin using JUnit:

```kotlin
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    MyTestClass::class,
    AnotherTestClass::class
)
class MyTestSuite
```

In this example, `MyTestSuite` is a test suite that includes test classes `MyTestClass` and `AnotherTestClass`. When you run `MyTestSuite`, all the test cases within the included test classes will be executed.

In summary, understanding the basic concepts of test cases, assertions, and test suites is essential for writing effective unit tests in Kotlin. These concepts form the foundation of unit testing practices and help ensure the reliability and correctness of your codebase.

## Configuring testing dependencies in Kotlin projects

Configuring testing dependencies in Kotlin projects involves setting up the necessary libraries and tools to support unit testing. Typically, this includes adding dependencies for testing frameworks, assertion libraries, and optionally, mocking frameworks. Below, I'll outline the steps to configure testing dependencies in a Kotlin project using Gradle as the build system.

### 1. Gradle Configuration

Assuming you're using Gradle as your build system, you'll need to modify your `build.gradle.kts` or `build.gradle` file to include dependencies for testing frameworks and libraries.

```kotlin
// Add JUnit Jupiter as the testing framework
dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}
```

### 2. Assertion Libraries

You may also want to include assertion libraries to make your test cases more expressive and readable. One common choice is AssertJ, which provides a fluent API for assertions.

```kotlin
dependencies {
    testImplementation("org.assertj:assertj-core:3.21.0")
}
```

### 3. Optional: Mocking Frameworks

If your tests require mocking objects or behaviors, you can include a mocking framework like Mockito.

```kotlin
dependencies {
    testImplementation("org.mockito:mockito-core:3.12.4")
}
```

### 4. Sync and Build

After adding the dependencies, sync your Gradle project to ensure that the new dependencies are downloaded and available for use. You can do this by running:

```bash
./gradlew clean build
```

### 5. Writing Tests

With the dependencies configured, you can now write tests using the testing framework (JUnit), assertion library (AssertJ), and mocking framework (Mockito) if needed. Here's an example of a simple JUnit test in Kotlin:

```kotlin
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class MyTestClass {

    @Test
    fun `test addition`() {
        val result = add(2, 3)
        assertEquals(5, result)
    }

    private fun add(a: Int, b: Int): Int {
        return a + b
    }
}
```

### 6. Running Tests

You can run your tests using the Gradle command-line interface:

```bash
./gradlew test
```

This command will execute all the tests in your project and provide you with a report on the test results.

Configuring testing dependencies in Kotlin projects involves adding dependencies for testing frameworks, assertion libraries, and optionally, mocking frameworks. By following the steps outlined above, you can set up a robust testing environment for your Kotlin projects and ensure the reliability and correctness of your code through unit tests.

## Choosing testing frameworks (JUnit, Spek, etc.)

Choosing the right testing framework for your Kotlin project depends on various factors such as project requirements, team preferences, and familiarity with the frameworks. Let's explore some popular testing frameworks in the Kotlin ecosystem and discuss their features, use cases, and considerations for choosing them.

### 1. JUnit 5

**Features:**

- JUnit 5 is the latest version of the JUnit testing framework, offering improved features and extensibility over previous versions.
- Supports writing both traditional JUnit 4-style tests and new JUnit 5 Jupiter-style tests.
- Provides annotations like `@Test`, `@BeforeEach`, `@AfterEach`, etc., for writing test cases.
- Supports parameterized tests, nested tests, and dynamic tests.
- Integrates well with popular IDEs and build tools.

**Use Cases:**

- Suitable for most Kotlin projects, especially those migrating from Java or requiring compatibility with Java libraries.
- Offers a wide range of features for writing comprehensive unit tests.

**Considerations:**

- If you're already familiar with JUnit from Java development, transitioning to JUnit 5 in Kotlin is relatively straightforward.
- It's a mature and widely adopted framework with extensive community support and documentation.

### 2. Spek

**Features:**

- Spek is a behavior-driven development (BDD) testing framework inspired by frameworks like Jasmine and RSpec.
- Provides a descriptive syntax for writing tests in a more human-readable format.
- Supports nested tests and clear separation between setup, action, and verification phases.
- Offers extensibility through custom DSLs for creating expressive and domain-specific tests.

**Use Cases:**

- Ideal for projects where readability and clarity of tests are crucial, such as in BDD-style development.
- Suitable for teams familiar with BDD concepts or transitioning from other BDD frameworks.

**Considerations:**

- Spek's DSL might require a learning curve for teams unfamiliar with BDD or the Spek framework itself.
- While it offers expressive tests, it may lead to more verbose test code compared to traditional testing frameworks like JUnit.

### 3. KotlinTest

**Features:**

- KotlinTest is a flexible and feature-rich testing framework designed specifically for Kotlin.
- Offers a variety of testing styles, including behavior-driven development (BDD) with `should` and `spec` keywords, and more traditional `describe` and `test` blocks.
- Provides a rich set of matchers and assertions for writing expressive and concise tests.
- Supports integration with popular mocking libraries like Mockito and MockK.

**Use Cases:**

- Suitable for Kotlin projects that prioritize expressive and concise test code.
- Offers flexibility in testing styles, allowing teams to choose between BDD-style or traditional testing approaches.

**Considerations:**

- KotlinTest may introduce additional dependencies compared to using JUnit alone.
- While it provides flexibility, teams need to establish conventions for consistent test writing styles across the project.

When choosing a testing framework for your Kotlin project, consider factors such as familiarity with the framework, project requirements, and team preferences. JUnit 5 is a solid choice for most Kotlin projects, offering maturity, compatibility, and extensive features. Spek is ideal for projects that prioritize readability and follow behavior-driven development practices. KotlinTest provides flexibility and expressive testing styles tailored specifically for Kotlin projects. Evaluate these frameworks based on your project's needs to make an informed decision.

## Writing test functions in Kotlin

Writing test functions in Kotlin involves using testing frameworks like JUnit or KotlinTest to define and execute test cases. These frameworks provide annotations, assertions, and utilities to facilitate writing and running tests. Below, I'll demonstrate how to write test functions using JUnit 5 and KotlinTest, two commonly used testing frameworks in the Kotlin ecosystem.

### Using JUnit 5

1. **Setup Dependencies**: Make sure you have the JUnit 5 dependencies configured in your project, as described in the previous response.

2. **Write Test Functions**: Use the `@Test` annotation to mark functions as test cases. You can then use assertion methods from the JUnit framework to verify the expected behavior.

```kotlin
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class MyTestClass {

    @Test
    fun `test addition`() {
        val result = add(2, 3)
        assertEquals(5, result)
    }

    private fun add(a: Int, b: Int): Int {
        return a + b
    }
}
```

3. **Run Tests**: Execute the tests using your IDE's test runner or Gradle command-line interface (`./gradlew test`).

### Using KotlinTest

1. **Setup Dependencies**: Configure KotlinTest dependencies in your Gradle build file.

```kotlin
dependencies {
    testImplementation("io.kotest:kotest-framework-engine:4.6.3")
    testImplementation("io.kotest:kotest-assertions-core:4.6.3")
}
```

2. **Write Test Functions**: Use KotlinTest's DSL to define test cases. You can use functions like `test` or `should` to create test cases and assertions to verify behavior.

```kotlin
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class MyTest : StringSpec() {
    init {
        "addition test" {
            val result = add(2, 3)
            result shouldBe 5
        }
    }

    private fun add(a: Int, b: Int): Int {
        return a + b
    }
}
```

3. **Run Tests**: Execute the tests using your IDE's test runner or Gradle command-line interface (`./gradlew test`).

Writing test functions in Kotlin involves defining functions annotated with testing framework-specific annotations (such as `@Test` in JUnit or using DSL provided by KotlinTest) and using assertion methods to verify behavior. Choose the testing framework that best fits your project's requirements and team preferences, and ensure that dependencies are configured correctly for seamless test execution.

## Grouping tests using test suites and test classes

Grouping tests using test suites and test classes helps organize and structure your test code, making it easier to manage and maintain, especially in larger projects. In this explanation, I'll demonstrate how to group tests using both approaches with JUnit 5, a popular testing framework in the Kotlin ecosystem.

### Grouping Tests with Test Suites

Test suites allow you to group multiple test classes together for execution. Here's how you can create a test suite in JUnit 5:

1. **Create a Test Suite Class**: Define a new Kotlin class that serves as the test suite. This class should be annotated with `@RunWith` (JUnit 4) or `@ExtendWith` (JUnit 5) and `@Suite` to indicate that it's a test suite.

2. **Specify Test Classes**: Within the test suite class, specify the test classes that you want to include in the suite using the `@Suite.SuiteClasses` annotation.

```kotlin
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.platform.suite.api.SelectClasses
import org.junit.platform.suite.api.Suite

@ExtendWith(Suite::class)
@Suite.SuiteClasses(
    MyTestClass1::class,
    MyTestClass2::class
)
class MyTestSuite
```

3. **Run the Test Suite**: Execute the test suite class to run all the tests from the included test classes.

### Grouping Tests with Test Classes

Test classes allow you to group related tests together based on functionality or module. Each test class contains multiple test methods that focus on testing specific aspects of the code. Here's how you can create test classes in Kotlin:

1. **Create Test Classes**: Define separate Kotlin classes for different test scenarios or functionalities. Each test class should contain test methods annotated with `@Test`.

```kotlin
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class AdditionTest {
    @Test
    fun `test addition`() {
        val result = add(2, 3)
        assertEquals(5, result)
    }

    private fun add(a: Int, b: Int): Int {
        return a + b
    }
}

class SubtractionTest {
    @Test
    fun `test subtraction`() {
        val result = subtract(5, 3)
        assertEquals(2, result)
    }

    private fun subtract(a: Int, b: Int): Int {
        return a - b
    }
}
```

2. **Run Test Classes**: Execute individual test classes or run all test classes together using your IDE's test runner or Gradle command-line interface (`./gradlew test`).

Both test suites and test classes offer effective ways to organize and structure your test code in Kotlin projects. Test suites are useful for grouping multiple test classes together, while test classes help organize tests within a specific context or functionality. Choose the grouping approach that best fits your project's requirements and ensures clarity and maintainability in your test suite.

## Using built-in assertions and matchers

In Kotlin, when writing unit tests, you often need to make assertions to verify that certain conditions hold true during the execution of your test cases. Kotlin doesn't have built-in assertion functions like some other languages, but you can leverage assertion libraries provided by testing frameworks such as JUnit, KotlinTest, or AssertJ. Additionally, Kotlin has some features that make writing assertions more concise and readable, such as the `assert` function and the use of extension functions.

### Using JUnit Assertions

JUnit provides a set of assertion methods in the `Assertions` class for making assertions in your test cases. Here are some examples of using JUnit assertions:

```kotlin
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MyTestClass {

    @Test
    fun `test addition`() {
        val result = add(2, 3)
        assertEquals(5, result)
    }

    private fun add(a: Int, b: Int): Int {
        return a + b
    }
}
```

In this example, `assertEquals` is used to check if the result of adding 2 and 3 equals 5. JUnit provides various other assertion methods like `assertTrue`, `assertFalse`, `assertNotNull`, `assertNull`, etc.

### Using KotlinTest Matchers

KotlinTest provides a rich set of matchers that can be used to make assertions in a more expressive and fluent way. Here's how you can use KotlinTest matchers:

```kotlin
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class MyTest : StringSpec() {
    init {
        "addition test" {
            val result = add(2, 3)
            result shouldBe 5
        }
    }

    private fun add(a: Int, b: Int): Int {
        return a + b
    }
}
```

In this example, `shouldBe` is used to assert that the result of adding 2 and 3 should be equal to 5. KotlinTest provides a wide range of matchers for different types of assertions.

### Using AssertJ

AssertJ is another assertion library that provides a fluent and expressive API for making assertions in your test cases. Here's an example of using AssertJ assertions:

```kotlin
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MyTestClass {

    @Test
    fun `test addition`() {
        val result = add(2, 3)
        assertThat(result).isEqualTo(5)
    }

    private fun add(a: Int, b: Int): Int {
        return a + b
    }
}
```

In this example, `assertThat` is used along with `isEqualTo` to assert that the result of adding 2 and 3 is equal to 5. AssertJ provides a fluent API with a wide range of assertion methods for different types of assertions.

When writing unit tests in Kotlin, you can make use of assertion libraries provided by testing frameworks like JUnit, KotlinTest, or AssertJ to make assertions in your test cases. These libraries offer various assertion methods and matchers that help you write concise, expressive, and readable assertions in your tests. Choose the assertion library that best fits your project's requirements and coding style preferences.

## Custom assertions and matchers

Custom assertions and matchers allow you to define your own assertion logic tailored to the specific needs of your application domain. This enhances the expressiveness and readability of your tests by allowing you to create assertions that directly reflect the behavior you are testing. In Kotlin, you can create custom assertions and matchers using extension functions, lambdas, or custom classes. Below, I'll demonstrate how to create custom assertions and matchers using JUnit, KotlinTest, and AssertJ.

### Using JUnit Custom Assertions

You can create custom assertions in JUnit by defining extension functions on the test subject's class or companion object. Here's an example:

```kotlin
import org.junit.jupiter.api.Assertions.assertEquals

fun String.shouldContainIgnoreCase(substring: String) {
    val actualLower = this.toLowerCase()
    val expectedLower = substring.toLowerCase()
    assertEquals(true, actualLower.contains(expectedLower), "Expected '$this' to contain '$substring' (case-insensitive)")
}
```

Usage:

```kotlin
import org.junit.jupiter.api.Test

class MyTest {

    @Test
    fun `test custom assertion`() {
        val string = "Hello, World!"
        string.shouldContainIgnoreCase("world")
    }
}
```

### Using KotlinTest Custom Matchers

KotlinTest allows you to create custom matchers using lambdas. Here's how you can define a custom matcher:

```kotlin
import io.kotest.matchers.Matcher
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe

fun <T> beGreaterThan(n: T) = object : Matcher<T> {
    override fun test(value: T) = Result(value > n, "$value should be greater than $n", "$value should not be greater than $n")
}
```

Usage:

```kotlin
import io.kotest.core.spec.style.StringSpec

class MyTest : StringSpec() {
    init {
        "test custom matcher" {
            val number = 10
            number shouldBe beGreaterThan(5)
        }
    }
}
```

### Using AssertJ Custom Assertions

AssertJ allows you to create custom assertions using chained method calls. Here's an example:

```kotlin
import org.assertj.core.api.AbstractAssert

class CustomStringAssert(actual: String) : AbstractAssert<CustomStringAssert, String>(actual, CustomStringAssert::class.java) {

    fun containsIgnoreCase(substring: String): CustomStringAssert {
        val actualLower = actual.toLowerCase()
        val expectedLower = substring.toLowerCase()
        if (!actualLower.contains(expectedLower)) {
            failWithMessage("Expected <%s> to contain <%s> (case-insensitive)", actual, substring)
        }
        return this
    }

    companion object {
        fun assertThat(actual: String): CustomStringAssert {
            return CustomStringAssert(actual)
        }
    }
}
```

Usage:

```kotlin
import org.junit.jupiter.api.Test

class MyTest {

    @Test
    fun `test custom assertion`() {
        val string = "Hello, World!"
        CustomStringAssert.assertThat(string).containsIgnoreCase("world")
    }
}
```

Creating custom assertions and matchers allows you to tailor your test code to the specific requirements of your application domain, improving the clarity and expressiveness of your tests. Whether you're using JUnit, KotlinTest, or AssertJ, each testing framework provides mechanisms for defining custom assertions and matchers. Choose the approach that best fits your project's needs and coding style preferences.

## Understanding test doubles

Test doubles are objects that are used as replacements for real dependencies in unit tests. They simulate the behavior of real objects, allowing you to isolate the code under test and verify its behavior without relying on the actual implementations of its dependencies. Test doubles are commonly used in unit testing to improve testability, speed up test execution, and enable thorough testing of individual components.

There are several types of test doubles:

1. **Dummy**: Dummy objects are typically placeholders that are passed around but never actually used. They are used when a parameter is required for a method call but its value doesn't affect the test outcome.

2. **Stub**: Stubs provide canned responses to method calls made during the test. They are used to simulate specific behaviors of dependencies that are needed for the test but aren't the focus of the test itself.

3. **Mock**: Mocks are objects pre-programmed with expectations about the calls they are expected to receive during the test. They record these calls and allow you to verify that the correct interactions occurred. Mocks are useful for testing interactions between objects.

4. **Spy**: Spies are similar to mocks, but they retain the original behavior of the real object while allowing you to track interactions with it. They can be useful when you want to test the behavior of an object while still using its real implementation for certain methods.

5. **Fake**: Fakes are simplified implementations of dependencies that behave similarly to the real implementation but are optimized for testing. They are usually lighter and faster than the real dependencies and are used when the real dependencies are too complex or slow for testing purposes.

Here's a brief overview of how you might use each type of test double in a Kotlin unit test:

- **Dummy**: If a method requires a parameter that isn't used in the test, you can pass a dummy object to satisfy the method signature.
- **Stub**: When a method being tested requires data from a dependency, you can create a stub that returns predetermined data to simulate the dependency's behavior.

- **Mock**: Use a mocking framework like Mockito or MockK to create mock objects with predefined behavior and verify that the tested object interacts with its dependencies correctly.

- **Spy**: Create a spy object using a mocking framework or manually extend the real object's class and override specific methods to track interactions while retaining the real behavior.

- **Fake**: Implement simplified versions of dependencies that are optimized for testing purposes and provide the necessary behavior for the test.

In summary, test doubles are essential for isolating the code under test and verifying its behavior in unit tests. By using test doubles effectively, you can write more focused, reliable, and maintainable unit tests for your Kotlin applications.

## Using libraries like Mockito for creating mocks

Certainly! Mockito is a popular Java mocking framework that is widely used in Kotlin projects as well. It allows you to create mock objects with predefined behavior and verify interactions with them. Here's how you can use Mockito in Kotlin for creating mocks:

### 1. Setup Mockito in Gradle

Add the Mockito dependency to your `build.gradle.kts` file:

```kotlin
dependencies {
    testImplementation("org.mockito.kotlin:mockito-kotlin:4.2.0")
}
```

### 2. Using Mockito in Kotlin Tests

Let's say you have a simple class `Calculator` that you want to test:

```kotlin
class Calculator {
    fun add(a: Int, b: Int): Int {
        return a + b
    }
}
```

You want to test another class `CalculatorService` that uses `Calculator`. Instead of using the real `Calculator` object, you'll create a mock `Calculator` object using Mockito.

```kotlin
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class CalculatorServiceTest {

    @Test
    fun `test addition`() {
        // Create a mock Calculator object
        val calculatorMock = mock<Calculator>()

        // Define behavior for the mock object
        whenever(calculatorMock.add(2, 3)).thenReturn(5)

        // Create CalculatorService object with the mock Calculator
        val calculatorService = CalculatorService(calculatorMock)

        // Test the CalculatorService
        val result = calculatorService.addNumbers(2, 3)

        // Verify the result
        assertEquals(5, result)
    }
}
```

In this example:

- We create a mock `Calculator` object using `mock<Calculator>()`.
- We define the behavior of the mock object using `whenever(calculatorMock.add(2, 3)).thenReturn(5)`. This tells Mockito that when `add(2, 3)` is called on the mock object, it should return 5.
- We create a `CalculatorService` object with the mock `Calculator` and test its functionality.
- Finally, we verify the result using assertions.

Mockito is a powerful tool for creating mock objects in Kotlin tests. It allows you to isolate the code under test and focus on testing specific behaviors without relying on real dependencies. By using Mockito effectively, you can write more robust and maintainable unit tests for your Kotlin applications.
