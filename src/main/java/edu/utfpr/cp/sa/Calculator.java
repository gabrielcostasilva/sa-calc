package edu.utfpr.cp.sa;

public class Calculator {

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

}
