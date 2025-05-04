package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DivisionByZeroTest {
    Validator validator = new Validator();

    @Test
    void testDivisionByZeroShouldFail() {
        boolean result = validator.validateDivisionByZero("/", 0);
        assertFalse(result, "Division by zero should be invalid");
    }

    @Test
    void testDivisionByNonZeroShouldPass() {
        boolean result = validator.validateDivisionByZero("/", 5);
        assertTrue(result, "Division by non-zero should be valid");
    }
}
