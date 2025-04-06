package com.bridgelabz.advance;

import java.util.HashMap;
import java.util.Map;

public class TestMapper {
    public static void main(String[] args) {
        Map<String, Object> props = new HashMap<>();
        props.put("name", "Sanjeev");
        props.put("age", 25);

        Person person = ObjectMapper.toObject(Person.class, props);
        System.out.println("Name: " + person.name);
        System.out.println("Age: " + person.age);
    }
}
