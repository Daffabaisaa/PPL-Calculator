package org.example;

public class App {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        Validator validator = new Validator();
        Computation computation = new Computation();

        String input1;
        do {
            input1 = inputHandler.getNumberInput("Enter first number: ");
        } while (!validator.validateNumeric(input1) || !validator.validateRange(Integer.parseInt(input1)));
        int operand1 = Integer.parseInt(input1);

        String input2;
        do {
            input2 = inputHandler.getNumberInput("Enter second number: ");
        } while (!validator.validateNumeric(input2) || !validator.validateRange(Integer.parseInt(input2)));
        int operand2 = Integer.parseInt(input2);

        String operator;
        do {
            operator = inputHandler.getOperatorInput("Enter operator (+, -, *, /): ");
        } while (!validator.validateOperator(operator));

        // Validasi khusus division by zero
        while (operator.equals("/") && !validator.validateDivisionByZero(operator, operand2)) {
            input2 = inputHandler.getNumberInput("Enter second number: ");
            if (validator.validateNumeric(input2) && validator.validateRange(Integer.parseInt(input2))) {
                operand2 = Integer.parseInt(input2);
            }
        }

        // Semua validasi lolos, lakukan komputasi
        int result = computation.compute(operator, operand1, operand2);
        System.out.println("Result: " + result);
    }
}