package com.bridelabz.basic;

import java.lang.reflect.*;
import java.util.Scanner;

public class ReflectionPractice {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter fully qualified class name (e.g. java.util.ArrayList): ");
        String className = scanner.nextLine();

        try {
            // Load class dynamically
            Class<?> clazz = Class.forName(className);

            // Print class name
            System.out.println("\nClass: " + clazz.getName());

            // Print fields
            System.out.println("\nFields:");
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                System.out.println("  " + Modifier.toString(field.getModifiers()) + " " +
                        field.getType().getSimpleName() + " " + field.getName());
            }

            // Print constructors
            System.out.println("\nConstructors:");
            Constructor<?>[] constructors = clazz.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.print("  " + Modifier.toString(constructor.getModifiers()) + " " + constructor.getName() + "(");
                Class<?>[] paramTypes = constructor.getParameterTypes();
                for (int i = 0; i < paramTypes.length; i++) {
                    System.out.print(paramTypes[i].getSimpleName());
                    if (i < paramTypes.length - 1) System.out.print(", ");
                }
                System.out.println(")");
            }

            // Print methods
            System.out.println("\nMethods:");
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                System.out.print("  " + Modifier.toString(method.getModifiers()) + " " +
                        method.getReturnType().getSimpleName() + " " +
                        method.getName() + "(");
                Class<?>[] paramTypes = method.getParameterTypes();
                for (int i = 0; i < paramTypes.length; i++) {
                    System.out.print(paramTypes[i].getSimpleName());
                    if (i < paramTypes.length - 1) System.out.print(", ");
                }
                System.out.println(")");
            }

        } catch (ClassNotFoundException e) {
            System.err.println("Class not found: " + className);
        }

        scanner.close();
    }
}
