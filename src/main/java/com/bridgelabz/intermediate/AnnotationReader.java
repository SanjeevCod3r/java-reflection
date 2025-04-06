package com.bridgelabz.intermediate;

import java.lang.annotation.Annotation;

public class AnnotationReader {

    public static void main(String[] args) {
        // Load the Book class
        Class<Book> bookClass = Book.class;

        // Check if the annotation is present
        if (bookClass.isAnnotationPresent(Author.class)) {
            // Get the annotation
            Author authorAnnotation = bookClass.getAnnotation(Author.class);

            // Display the annotation value
            System.out.println("Author: " + authorAnnotation.name());
        } else {
            System.out.println("No @Author annotation found.");
        }
    }
}
