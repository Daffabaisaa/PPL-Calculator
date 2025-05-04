package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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

    @Test
    public void testValidateNumericWithValidInteger() {
        Validator validator = new Validator();
        boolean result = validator.validateNumeric("5");
        assertTrue(result, "Seharusnya true untuk input '5'");
    }

    @Test
    public void testValidateNumericWithInvalidDecimal() {
        Validator validator = new Validator();

        // Tangkap output error
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        boolean result = validator.validateNumeric("5.5");

        // Validasi return value
        assertFalse(result, "Seharusnya false untuk input '5.5'");

        // Validasi output error muncul
        String output = outputStream.toString();
        assertTrue(output.contains("Error: Input must be a number."), "Pesan error harus muncul");
    }

    @Test
    public void testValidateRangeValidInput() {
        Validator validator = new Validator();
        boolean result = validator.validateRange(32766);
        assertTrue(result, "Angka 32766 masih dalam range, seharusnya true");
    }

    @Test
    public void testValidateRangeBelowMinimum() {
        Validator validator = new Validator();

        // Tangkap output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        boolean result = validator.validateRange(-32769);  // di bawah batas minimum
        assertFalse(result, "Angka -32769 di bawah range, seharusnya false");

        String output = outputStream.toString();
        assertTrue(output.contains("Error: Number out of range"), "Harus ada pesan error");
    }

    @Test
    public void testValidateRangeAboveMaximum() {
        Validator validator = new Validator();

        // Tangkap output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        boolean result = validator.validateRange(32768);  // di atas batas maksimum
        assertFalse(result, "Angka 32768 di atas range, seharusnya false");

        String output = outputStream.toString();
        assertTrue(output.contains("Error: Number out of range"), "Harus ada pesan error");
    }
}

