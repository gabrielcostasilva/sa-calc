# Calculator
This project introduces a calculator that calculates four basic operations: addition, subtraction, multiplication, and division. 

This project is used throughout the Software Architecture module I teach at [Universidade Tecnológica Federal do Paraná, Cornélio Procópio, Brasil](http://www.utfpr.edu.br/campus/cornelioprocopio) for Software Engineering graduate students. 

The main branch shows a use case for the [KISS principle](https://en.wikipedia.org/wiki/KISS_principle) implementation. Check out other branches to find out how this project evolves to address other design principles.

## Project Overview
This calculator consists of one single class - [Calculator](./src/main/java/edu/utfpr/cp/sa/Calculator.java). This class defines a single method that choose the operation based on command line arguments. The code below shows the full method.

```java
public static void main(String[] args) {
    double a = Double.parseDouble(args[0]); // (1)
    double b = Double.parseDouble(args[2]); // (1)

    char op = args[1].charAt(0); // (1)

    double result = switch (op) { // (2)
        case '+' -> a + b; // (3)
        case '-' -> a - b; // (3)
        case 'x' -> a * b; // (3)
        case '/' -> a / b; // (3)
        default -> throw new IllegalArgumentException("Unknown operator: " + op); // (4)
    };

    System.out.println(result); // (5)
}
```

1. Transforms command line arguments into values representing two numbers (first and third arguments) and a sign (second argument).
2. Decides which operation to perform.
3. Calculates the result for a given operation.
4. Deals with unknown operators.
5. Print out the result.

## Project Setup
This project requires Maven and Java 17 installed. The easiest way to run the project is building a package.

Within the project folder, type and run: `mvn clean package`. This will generate the `target` folder with a compiled `jar` file.

To try out the app, type and run: `java -jar target/calculator-1.0-SNAPSHOT.jar 1 + 2`

Please notice that the last three arguments represent the values and the operation that the calculator uses.

## Testing
This project features a [test class](./src/test/java/edu/utfpr/cp/sa/CalculatorTest.java) that asserts the implementation correctness. This project uses JUnit 5 for creating unit tests.

One can run all tests by typing and running: `mvn clean test`

