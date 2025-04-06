package com.bridelabz.basic;

public class ReflectionCreateObject {

    public static void main(String[] args) {
        try {
            // Load the Student class dynamically
            Class<?> clazz = Class.forName("com.bridelabz.basic.Student");

            // Create an instance using the default constructor
            Object studentObject = clazz.getDeclaredConstructor().newInstance();

            // Optionally cast to Student and use it
            if (studentObject instanceof Student) {
                Student students = (Student) studentObject;
                students.showName();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
