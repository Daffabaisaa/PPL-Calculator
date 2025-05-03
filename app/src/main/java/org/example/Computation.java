package org.example;

public class Computation {
    private Calculator calculator = new Calculator();

    public int compute(String operator, int operand1, int operand2) {
        switch (operator) {
            case "+": return calculator.add(operand1, operand2);
            case "-": return calculator.subtract(operand1, operand2);
            case "*": return calculator.multiply(operand1, operand2);
            case "/": return calculator.divide(operand1, operand2);
            default: throw new IllegalArgumentException("Invalid operator");
        }
    }
}
