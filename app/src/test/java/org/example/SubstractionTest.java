package org.example;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import java.io.*;

public class SubstractionTest {

    @Test
    public void testSubtractionPositiveNumbers() {
        String simulatedInput = "10\n4\n-\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        App.main(null);

        String output = outputStream.toString();
        printStream.flush();

        assertTrue(output.contains("Result: 6"), "Output harus mengandung 'Result: 6'");
    }

    @Test
    public void testSubtractionWithNegativeResult() {
        String simulatedInput = "3\n7\n-\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        App.main(null);

        String output = outputStream.toString();
        printStream.flush();

        assertTrue(output.contains("Result: -4"), "Output harus mengandung 'Result: -4'");
    }

    @Test
    public void testSubtractionWithZero() {
        String simulatedInput = "5\n0\n-\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        App.main(null);

        String output = outputStream.toString();
        printStream.flush();

        assertTrue(output.contains("Result: 5"), "Output harus mengandung 'Result: 5'");
    }
}
