package org.example.model;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ClassDescriptor {
    private Class<?> clazz;

    public ClassDescriptor(Class<?> clazz) {
        this.clazz = clazz;
    }

    public String getFullName() {
        return clazz.getName();
    }

    public List<String> getMethodNames() {
        List<String> methodNames = new ArrayList<>();
        for (Method method : clazz.getDeclaredMethods()) {
            methodNames.add(method.getName());
        }
        return methodNames;
    }

    public List<String> getFieldNames() {
        List<String> fieldNames = new ArrayList<>();
        for (Field field : clazz.getDeclaredFields()) {
            fieldNames.add(field.getName());
        }
        return fieldNames;
    }

    public String getInfo() {
        int indexNumber = clazz.getAnnotation(Info.class).nr();
        String firstName = clazz.getAnnotation(Info.class).firstName();
        String lastName = clazz.getAnnotation(Info.class).lastName();

        if(!clazz.isAnnotationPresent(Info.class)) {
            return null;
        }
        return "index: s%d, first name: %s, last name: %s".formatted(indexNumber, firstName, lastName);
    }
}
