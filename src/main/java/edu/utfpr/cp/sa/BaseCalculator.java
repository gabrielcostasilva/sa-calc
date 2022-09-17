package edu.utfpr.cp.sa;

import java.util.HashMap;
import java.util.Map;
import java.util.function.ToDoubleBiFunction;

public abstract class BaseCalculator {

    Map<Character, ToDoubleBiFunction<Double, Double>> operationMap;

    BaseCalculator() {
        operationMap = new HashMap<>();

    }

    public void chooseAndPerform(String[] args) {
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[2]);

        char op = args[1].charAt(0);

        double result = operationMap.get(op).applyAsDouble(a, b);

        System.out.println(result);
    }

}
