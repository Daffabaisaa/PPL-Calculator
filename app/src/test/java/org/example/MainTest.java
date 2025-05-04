package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {

    @Test
    public void testValidCondition() {
        String simulatedInput = "10\n5\n+\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        App.main(null);

        String output = outputStream.toString();
        assertTrue(output.contains("Result: 15"), "Output harus mengandung 'Result: 15'");
    }

    @Test
    public void testDivisionWithNegative() {
        String simulatedInput = "12\n-2\n/\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        App.main(null);

        String output = outputStream.toString();
        assertTrue(output.contains("Result: -6"), "Output harus mengandung 'Result: -6'");
    }

    @Test
    public void testDivisionByZeroWithRetry() {
        String simulatedInput = "14\n0\n/\n1\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        App.main(null);

        String output = outputStream.toString();
        assertTrue(output.contains("Error: Division by zero is not allowed."),
                "Output harus mengandung 'Error: Division by zero is not allowed.'");
        assertTrue(output.contains("Result: 14"), "Output harus mengandung 'Result: 14'");
    }

    @Test
    public void testInvalidOperand1Retry() {
        String simulatedInput = "q\n1\n2\n+\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        App.main(null);

        String output = outputStream.toString();
        assertTrue(output.contains("Result: 3"), "Output harus mengandung 'Result: 3'");
    }

    @Test
    public void testOutOfRangeOperand1Retry() {
        String simulatedInput = "111111\n3\n2\n+\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        App.main(null);

        String output = outputStream.toString();
        assertTrue(output.contains("Result: 5"), "Output harus mengandung 'Result: 5'");
    }

    @Test
    public void testInvalidOperand2Retry() {
        String simulatedInput = "6\n`\n5\n-\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        App.main(null);

        String output = outputStream.toString();
        assertTrue(output.contains("Result: 1"), "Output harus mengandung 'Result: 1'");
    }

    @Test
    public void testOutOfRangeOperand2Retry() {
        String simulatedInput = "3\n111111\n5\n-\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        App.main(null);

        String output = outputStream.toString();
        assertTrue(output.contains("Result: -2"), "Output harus mengandung 'Result: -2'");
    }

    @Test
    public void testInvalidOperatorRetry() {
        String simulatedInput = "5\n0\na\n-\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        App.main(null);

        String output = outputStream.toString();
        assertTrue(output.contains("Result: 5"), "Output harus mengandung 'Result: 5'");
    }
}