package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class DivideTest {

    private final Calculator calculator = new Calculator();

    @Test
    public void testDividePositiveNumbers() {
        assertEquals(2, calculator.divide(10, 5), "10 / 5 should be 2");
    }

    @Test
    public void testDividePositiveAndNegativeNumbers() {
        assertEquals(-4, calculator.divide(8, -2), "8 / -2 should be -4");
    }

    @Test
    public void testDivideNegativeNumbers() {
        assertEquals(1, calculator.divide(-6, -6), "-6 / -6 should be 1");
    }

    @Test
    public void testDivideZeroByPositiveNumber() {
        assertEquals(0, calculator.divide(0, 9), "0 / 9 should be 0");
    }

    @Test
    public void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(7, 0), "Division by zero should throw ArithmeticException");
    }
}