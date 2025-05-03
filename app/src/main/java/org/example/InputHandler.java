package org.example;

import java.util.Scanner;

public class InputHandler {
    private final Scanner scanner = new Scanner(System.in);

    public String getNumberInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    public String getOperatorInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }
}