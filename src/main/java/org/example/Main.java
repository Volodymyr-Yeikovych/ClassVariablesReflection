package org.example;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        Person him = new Person("Vale", "Chambers", 17);

        printVariablesInfo(him);
    }

    public static<T> void printVariablesInfo(T t) throws IllegalAccessException {
        Field[] values = t.getClass().getDeclaredFields();
        for (Field field : values) {
            field.setAccessible(true);
            System.out.printf("Access Modifier:{%s}, Var Type:{%s}, Var Name:{%s}, Value:{%s}; %n", extractAccessModifier(field), field.getGenericType(), field.getName(), field.get(t));
            field.setAccessible(false);
        }
    }

    private static String extractAccessModifier(Field field) {
        return Modifier.toString(field.getModifiers());
    }
}