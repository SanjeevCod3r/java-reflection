package com.bridelabz.basic;

import java.lang.reflect.Field;

public class ReflectionAccessPrivateField {

    public static void main(String[] args) {
        try {
            // Create a new Person instance
            Person person = new Person();
            System.out.println("Before modification:");
            person.showAge();

            // Get the Class object
            Class<?> clazz = person.getClass();

            // Access private field "age"
            Field ageField = clazz.getDeclaredField("age");

            // Make the private field accessible
            ageField.setAccessible(true);

            // Set a new value to the field
            ageField.setInt(person, 42);

            // Retrieve the new value
            int updatedAge = ageField.getInt(person);

            System.out.println("After modification:");
            person.showAge(); // Confirm change via method
            System.out.println("Accessed via Reflection: Age = " + updatedAge);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

