package com.bridgelabz.advance;

import java.lang.reflect.Field;
import java.util.Map;

public class ObjectMapper {

    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) {
        try {
            // Create instance
            T instance = clazz.getDeclaredConstructor().newInstance();

            // Iterate through declared fields
            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true); // allow access to private fields

                // If property exists in map, set the value
                if (properties.containsKey(field.getName())) {
                    Object value = properties.get(field.getName());

                    // Handle type conversion if needed (simple type-safe version)
                    if (value != null && field.getType().isAssignableFrom(value.getClass())) {
                        field.set(instance, value);
                    } else if (value != null) {
                        // Convert basic types manually if needed (e.g. Integer -> int)
                        if (field.getType() == int.class && value instanceof Number) {
                            field.set(instance, ((Number) value).intValue());
                        } else if (field.getType() == double.class && value instanceof Number) {
                            field.set(instance, ((Number) value).doubleValue());
                        } // Add more conversions as needed
                    }
                }
            }
            return instance;

        } catch (Exception e) {
            throw new RuntimeException("Failed to map properties to object", e);
        }
    }
}
