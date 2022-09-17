package edu.utfpr.cp.sa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void shouldSum() {
        Calculator.main(new String[] { "1", "+", "2" });

        assertEquals(
            "3.0", 
            outputStreamCaptor.toString().trim());    
    }

    @Test
    public void shouldSubtract() {
        Calculator.main(new String[] { "2", "-", "1" });

        assertEquals(
            "1.0", 
            outputStreamCaptor.toString().trim());    
    }

    @Test
    public void shouldMultiply() {
        Calculator.main(new String[] { "2", "x", "2" });

        assertEquals(
            "4.0", 
            outputStreamCaptor.toString().trim());    
    }

    @Test
    public void shouldDivide() {
        Calculator.main(new String[] { "4", "/", "2" });

        assertEquals(
            "2.0", 
            outputStreamCaptor.toString().trim());    
    }

    @Test
    public void shouldSumBeWrong() {
        Calculator.main(new String[] { "2", "+", "2" });

        assertNotEquals(
            "3.0", 
            outputStreamCaptor.toString().trim());    
    }

    @Test
    public void shouldSubtractBeWrong() {
        Calculator.main(new String[] { "2", "-", "2" });

        assertNotEquals(
            "1.0", 
            outputStreamCaptor.toString().trim());    
    }

    @Test
    public void shouldMultiplyBeWrong() {
        Calculator.main(new String[] { "2", "x", "3" });

        assertNotEquals(
            "4.0", 
            outputStreamCaptor.toString().trim());    
    }

    @Test
    public void shouldDivideBeWrong() {
        Calculator.main(new String[] { "6", "/", "2" });

        assertNotEquals(
            "2.0", 
            outputStreamCaptor.toString().trim());    
    }

}
