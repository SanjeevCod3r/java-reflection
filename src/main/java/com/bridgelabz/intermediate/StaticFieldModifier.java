package com.bridgelabz.intermediate;

import java.lang.reflect.Field;

public class StaticFieldModifier {

    public static void main(String[] args) {
        try {
            // Print original API_KEY
            Configuration.printApiKey();

            // Get the Class object
            Class<?> configClass = Configuration.class;

            // Get the static field
            Field apiKeyField = configClass.getDeclaredField("API_KEY");

            // Make the private field accessible
            apiKeyField.setAccessible(true);

            // Modify the static field (pass null for static fields)
            apiKeyField.set(null, "UPDATED_SECRET_KEY");

            // Print updated API_KEY
            Configuration.printApiKey();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
