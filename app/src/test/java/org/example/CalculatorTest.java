package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @Test
    public void testAdd() {
        Calculator calculator = new Calculator();
        int result = calculator.add(5, 7);
        assertEquals(12, result, "5 + 7 seharusnya menghasilkan 12");
    }

    @Test
    public void testMultiply() {
        Calculator calculator = new Calculator();
        int result = calculator.multiply(5, 7);
        assertEquals(35, result, "5 * 7 seharusnya menghasilkan 35");
    }
}
