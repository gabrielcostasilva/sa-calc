package edu.utfpr.cp.sa;

public class BasicFourOperationsCalculator 
    extends ThreeOperationsCalculator {

    BasicFourOperationsCalculator() {
        operationMap.put('/', (a, b) -> a / b);
    }

    public static void main(String[] args) {
        var calc = new BasicFourOperationsCalculator();
        calc.chooseAndPerform(args);
    }
}
