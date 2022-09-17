package edu.utfpr.cp.sa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        OnlyAdditionCalculator.main(new String[] { "1", "+", "2" });

        assertEquals(
            "3.0", 
            outputStreamCaptor.toString().trim());    
    }

    @Test
    public void shouldSubtract() {
        AdditionAndSubtractionCalculator.main(new String[] { "2", "-", "1" });

        assertEquals(
            "1.0", 
            outputStreamCaptor.toString().trim());    
    }

    @Test
    public void shouldMultiply() {
        ThreeOperationsCalculator.main(new String[] { "2", "x", "2" });

        assertEquals(
            "4.0", 
            outputStreamCaptor.toString().trim());    
    }

    @Test
    public void shouldDivide() {
        BasicFourOperationsCalculator.main(new String[] { "4", "/", "2" });

        assertEquals(
            "2.0", 
            outputStreamCaptor.toString().trim());    
    }


    @Test
    public void shouldSubtractBeWrong() {

        assertThrows(
            Exception.class, 
            () -> OnlyAdditionCalculator.main(new String[] { "2", "-", "2" }));

    }

    @Test
    public void shouldMultiplyBeWrong() {

        assertThrows(
            Exception.class, 
            () -> AdditionAndSubtractionCalculator.main(new String[] { "2", "x", "2" }));

    }

    @Test
    public void shouldDivideBeWrong() {

        assertThrows(
            Exception.class, 
            () -> ThreeOperationsCalculator.main(new String[] { "2", "/", "2" }));
    }

}
