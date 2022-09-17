package edu.utfpr.cp.sa;

public class ThreeOperationsCalculator 
    extends AdditionAndSubtractionCalculator {

    ThreeOperationsCalculator() {
        operationMap.put('x', new MultiplicationOperation());
    }

    public static void main(String[] args) {
        var calc = new ThreeOperationsCalculator();
        calc.chooseAndPerform(args);
    }
    
}
