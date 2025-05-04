package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ComputeTest {

    private final Computation computation = new Computation();

    @Test
    public void testAddition() {
        assertEquals(15, computation.compute("+", 10, 5));
    }

    @Test
    public void testSubtraction() {
        assertEquals(5, computation.compute("-", 10, 5));
    }

    @Test
    public void testMultiplication() {
        assertEquals(50, computation.compute("*", 10, 5));
    }

    @Test
    public void testDivision() {
        assertEquals(2, computation.compute("/", 10, 5));
    }

    @Test
    public void testInvalidOperator() {
        assertThrows(IllegalArgumentException.class, () -> computation.compute("&", 10, 5));
    }
}
