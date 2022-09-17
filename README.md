# Extensible Calculator
This project is a spinoff from the [KISS calculator](https://github.com/gabrielcostasilva/sa-calc) implementation.

As the previous project, I use it in the Software Architecture module I teach at [Universidade Tecnológica Federal do Paraná, Cornélio Procópio, Brasil](http://www.utfpr.edu.br/campus/cornelioprocopio) for Software Engineering graduate students. 

Unlike the previous project, this shows off the [open-closed principle](https://en.wikipedia.org/wiki/Open–closed_principle). In a nutshell, the open-closed principle argues that a module should be open for extension, but closed for modification. 

As this project shows, this principle comes with a cost. **Please, do not get me wrong. Using the open-close principle IS NOT bad**. The point is that you should analyse whether it pays off before implementing it.

## Project Overview
The original calculator consists of a single class, with a single method, as the code snippet below shows. Please, check out the [original project](https://github.com/gabrielcostasilva/sa-calc) for further details.

```java
public static void main(String[] args) {
    double a = Double.parseDouble(args[0]); 
    double b = Double.parseDouble(args[2]); 

    char op = args[1].charAt(0); 

    double result = switch (op) { 
        case '+' -> a + b; 
        case '-' -> a - b; 
        case 'x' -> a * b; 
        case '/' -> a / b; 
        default -> throw new IllegalArgumentException("Unknown operator: " + op); 
    };

    System.out.println(result); 
}
```

To make this project extensible, we started by [moving arithmetic](#moving-arithmetic-operations-to-classes) operations to classes. [Then, we moved](#creating-calculator-superclass) the code that perform operations to a superclass. This superclass is also responsible for grouping available arithmetic operations. Finally, [we created subclasses](#extending-basecalculator) that set arithmetic operations that are available and perform those operations.

### Moving arithmetic operations to classes
We created a class for each arithmetic operation in the original code. These classes implement an interface ([`IOperation`](./src/main/java/edu/utfpr/cp/sa/IOperation.java)) that sets the contract for all arithmetic operations - as the code below shows. 

```java
public interface IOperation {
    double calculates(double a, double b);
    
}
```
This contract sets that any arithmetic operation receives two arguments and return a result. How an operation works is delegated to its implementation. This is an essential step to enables extension.

Next, we created implementations representing the four basic arithmetic operations in the original class. The code below shows the addition implementation.

```java
public class AdditionOperation 
    implements IOperation { // (1)

    @Override
    public double calculates(double a, double b) {
        return a + b; // (2)
    }
    
}
```

1. Adheres to the arithmetic operation contract.
2. Implements the addition operation.

### Creating calculator superclass
[`BaseCalculator`](./src/main/java/edu/utfpr/cp/sa/BaseCalculator.java) is a superclass responsible for receiving input data and calling the proper arithmetic operation. To do so, we moved the code from the `main()` method in the original class to the superclass, as the snippet below shows.

```java 
// (...)

public void chooseAndPerform(String[] args) {
    double a = Double.parseDouble(args[0]);
    double b = Double.parseDouble(args[2]);

    char op = args[1].charAt(0);

    double result = operationMap.get(op).calculates(a, b); // (1)

    System.out.println(result);
}

// (...)
```

The entire code remains the same, apart from (1). To identifying the set of arithmetic operations available, we created a `java.util.Map` called `operationMap` in the `BaseCalculator` class. `operationMap` maps a character and an `IOperation` implementation. The class constructor instantiates `operationMap`, and each subclass is responsible for adding arithmetic operations they support.

Thus, the code in (1) retrieves the arithmetic operation implementation according to the argument received, and calls the method responsible for performing the calculation.

### Extending BaseCalculator
Finally, we can create subclasses that extend `BaseCalculator` by adding arithmetic operations. The UML class diagram in the figure below shows the class structure. The diagram shows that `BaseCalculator` features are extended by `OnlyAdditionCalculator`. Besides, each new calculator implementation extends the previous one with a new feature.

<img src="./package.svg" />

The [`OnlyAdditionCalculator`](./src/main/java/edu/utfpr/cp/sa/OnlyAdditionCalculator.java) class extends `BaseCalculator` by adding the addition operation, as the code below shows. 

```java 
public class OnlyAdditionCalculator 
    extends BaseCalculator { // (1)

    OnlyAdditionCalculator() {
        operationMap.put('+', new AdditionOperation()); // (2)
        
    }

    public static void main(String[] args) { // (3)
        var calc = new OnlyAdditionCalculator();
        calc.chooseAndPerform(args);
    }
    
}
```
1. Sets a new feature without touching the original code.
2. Adds an arithmetic operation implementation.
3. Do the math by passing the arguments to the method in the superclass.

## Project Setup
This project requires Maven and Java 17 installed. The easiest way to run the project is building a package.

Within the project folder, type and run: `mvn clean package`. This will generate the `target` folder with a compiled `jar` file.

To try out the app, type and run: `java -jar target/calculator-1.0-SNAPSHOT.jar 1 + 2`

Please notice that the last three arguments represent the values and the operation that the calculator uses.

## Testing
This project features a [test class](./src/test/java/edu/utfpr/cp/sa/CalculatorTest.java) that asserts the implementation correctness. This project uses JUnit 5 for creating unit tests.

One can run all tests by typing and running: `mvn clean test`

