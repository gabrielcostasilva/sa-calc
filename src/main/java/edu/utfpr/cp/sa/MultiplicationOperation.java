package edu.utfpr.cp.sa;

public class MultiplicationOperation 
    implements IOperation {

    @Override
    public double calculates(double a, double b) {
        return a * b;
    }
    
}