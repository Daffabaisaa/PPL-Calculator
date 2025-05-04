package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ValidateOperatorTest {

    Validator validator = new Validator();

    @Test
    void testValidOperatorPlus() {
        assertTrue(validator.validateOperator("+"));
    }

    @Test
    void testValidOperatorMinus() {
        assertTrue(validator.validateOperator("-"));
    }

    @Test
    void testValidOperatorMultiply() {
        assertTrue(validator.validateOperator("*"));
    }

    @Test
    void testValidOperatorDivide() {
        assertTrue(validator.validateOperator("/"));
    }

    @Test
    void testInvalidOperatorModulo() {
        assertFalse(validator.validateOperator("%"));
    }

    @Test
    void testInvalidOperatorEmptyString() {
        assertFalse(validator.validateOperator(""));
    }

    @Test
    void testInvalidOperatorRandomString() {
        assertFalse(validator.validateOperator("abc"));
    }

    @Test
    void testNullOperatorThrowsException() {
        assertThrows(NullPointerException.class, () -> {
            validator.validateOperator(null);
        });
    }
}

