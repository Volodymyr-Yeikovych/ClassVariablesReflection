package org.example;

import javax.management.InvalidAttributeValueException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InvalidAttributeValueException {
        Person him = new Person.PersonBuilder("Vale", "Chambers", 17).build();

        printVariablesInfo(him);

        System.out.println();

        Person other = new Person.PersonBuilder("Kyle", "Hustles", 17).setMiddleName("Jan").build();

        printVariablesInfo(other);

        System.out.println();

        Person another = new Person.PersonBuilder().setName("Vasa").setAge(27).build();

        printVariablesInfo(another);
    }

    public static void printVariablesInfo(Object t) throws IllegalAccessException {
        Field[] values = t.getClass().getDeclaredFields();
        for (Field field : values) {
            field.setAccessible(true);
            String accessMod = Modifier.toString(field.getModifiers());
            System.out.printf("Access Modifier:{%s}, Var Type:{%s}, Var Name:{%s}, Value:{%s}; %n", accessMod, field.getGenericType(), field.getName(), field.get(t));
            field.setAccessible(false);
        }
    }


}