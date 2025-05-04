package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class AppTest {

    @Test
    public void testAdditionOutput() {
        // Simulasi input: 2 + 5
        String simulatedInput = "2\n5\n+\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        // Tangkap output program
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        // Jalankan program
        App.main(null);

        // Ambil output sebagai string
        String output = outputStream.toString();

        // Force flush output
        printStream.flush();

        // Cetak ke konsol (opsional)
        System.err.println("=== CAPTURED OUTPUT (Correct Case) ===");
        System.err.println(output);

        // Cek apakah hasil benar
        assertTrue(output.contains("Result: 7"), "Output harus mengandung 'Result: 7'");
    }
}
