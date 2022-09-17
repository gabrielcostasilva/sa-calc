package edu.utfpr.cp.sa;

public class AdditionAndSubtractionCalculator 
    extends OnlyAdditionCalculator {

    AdditionAndSubtractionCalculator() {
        operationMap.put('-', (a, b) -> a - b);

    }

    public static void main(String[] args) {
        var calc = new AdditionAndSubtractionCalculator();
        calc.chooseAndPerform(args);
    }
    
}
