package com.bridelabz.basic;

import java.lang.reflect.Method;

public class ReflectionInvokePrivateMethod {

    public static void main(String[] args) {
        try {
            // Create an instance of Calculator
            Calculator calculator = new Calculator();

            // Get the Class object
            Class<?> clazz = calculator.getClass();

            // Get the private method "multiply" with two int parameters
            Method multiplyMethod = clazz.getDeclaredMethod("multiply", int.class, int.class);

            // Make the private method accessible
            multiplyMethod.setAccessible(true);

            // Invoke the method with arguments
            Object result = multiplyMethod.invoke(calculator, 6, 7);

            // Display the result
            System.out.println("Result of multiply(6, 7): " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
