package org.example;

public class Validator {

    public boolean validateNumeric(String input) {
        if (!input.matches("-?\\d+")) {
            System.out.println("Error: Input must be a number.");
            return false;
        }
        return true;
    }

    public boolean validateRange(int number) {
        if (number < -32768 || number > 32767) {
            System.out.println("Error: Number out of range (-32,768 to 32,767).");
            return false;
        }
        return true;
    }

    public boolean validateOperator(String operator) {
        if (!(operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/"))) {
            System.out.println("Error: Invalid operator. Only +, -, *, / are allowed.");
            return false;
        }
        return true;
    }

    public boolean validateDivisionByZero(String operator, int divisor) {
        if (operator.equals("/") && divisor == 0) {
            System.out.println("Error: Division by zero is not allowed.");
            return false;
        }
        return true;
    }
}