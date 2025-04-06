package com.bridelabz.basic;

public class Student {
    private String name;

    public Student() {
        this.name = "Default Student";
    }

    public void showName() {
        System.out.println("Student Name: " + name);
    }
}
