package edu.utfpr.cp.sa;

public class OnlyAdditionCalculator 
    extends BaseCalculator {

    OnlyAdditionCalculator() {
        operationMap.put('+', (a, b) -> a + b);
        
    }

    public static void main(String[] args) {
        var calc = new OnlyAdditionCalculator();
        calc.chooseAndPerform(args);
    }
    
}
