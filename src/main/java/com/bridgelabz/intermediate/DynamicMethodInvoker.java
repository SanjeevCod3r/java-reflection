package com.bridgelabz.intermediate;

import java.lang.reflect.Method;
import java.util.Scanner;

public class DynamicMethodInvoker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            // Get user input for method name and parameters
            System.out.print("Enter method name (add, subtract, multiply): ");
            String methodName = scanner.nextLine();

            System.out.print("Enter first number: ");
            int a = scanner.nextInt();

            System.out.print("Enter second number: ");
            int b = scanner.nextInt();

            // Create an instance of MathOperations
            MathOperations operations = new MathOperations();
            Class<?> clazz = operations.getClass();

            // Get method based on name and parameter types
            Method method = clazz.getMethod(methodName, int.class, int.class);

            // Invoke the method dynamically
            Object result = method.invoke(operations, a, b);

            // Print the result
            System.out.println("Result of " + methodName + "(" + a + ", " + b + "): " + result);

        } catch (NoSuchMethodException e) {
            System.out.println("Method not found!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
