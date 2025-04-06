package com.bridgelabz.intermediate;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// This annotation will be available at runtime
@Retention(RetentionPolicy.RUNTIME)
public @interface Author {
    String name();
}
