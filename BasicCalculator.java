import java.util.Scanner;

public class BasicCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Basic Java Calculator ===");

        // 1. Get and validate the first number
        double num1 = getValidNumber(scanner, "Enter first number: ");

        // 2. Get and validate the operator
        char operator = getValidOperator(scanner);

        // 3. Get and validate the second number
        double num2 = getValidNumber(scanner, "Enter second number: ");

        // 4. Compute and display the result
        calculateAndDisplay(num1, operator, num2);

        scanner.close();
    }

    // Method to ensure the user inputs a valid number (integer or decimal)
    private static double getValidNumber(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                return scanner.nextDouble();
            } else {
                System.out.println("Error: Invalid number. Letters or symbols are not accepted.");
                scanner.next(); // Clear the invalid input from the buffer
            }
        }
    }

    // Method to ensure the user inputs a supported operator (+, -, *, /)
    private static char getValidOperator(Scanner scanner) {
        while (true) {
            System.out.print("Enter operator (+, -, *, /): ");
            String input = scanner.next();
            if (input.length() == 1) {
                char op = input.charAt(0);
                if (op == '+' || op == '-' || op == '*' || op == '/') {
                    return op;
                }
            }
            System.out.println("Error: Invalid operator. Please choose from +, -, *, or /.");
        }
    }

    // Method to perform the calculation and handle division by zero
    private static void calculateAndDisplay(double n1, char op, double n2) {
        double result = 0;

        switch (op) {
            case '+':
                result = n1 + n2;
                System.out.println("Result: " + n1 + " + " + n2 + " = " + result);
                break;
            case '-':
                result = n1 - n2;
                System.out.println("Result: " + n1 + " - " + n2 + " = " + result);
                break;
            case '*':
                result = n1 * n2;
                System.out.println("Result: " + n1 + " * " + n2 + " = " + result);
                break;
            case '/':
                // Handle division by zero
                if (n2 == 0) {
                    System.out.println("Error: Division by zero is not allowed.");
                } else {
                    result = n1 / n2;
                    System.out.println("Result: " + n1 + " / " + n2 + " = " + result);
                }
                break;
        }
    }
}