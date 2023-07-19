package org.example;

import org.jetbrains.annotations.Nullable;

import javax.management.InvalidAttributeValueException;
import java.util.Objects;

public class Person {
    private final String name;
    @Nullable
    private final String middleName;
    private final String surname;
    private final int age;

    public Person(PersonBuilder personBuilder) {
        this.name = personBuilder.name;
        this.middleName = personBuilder.middleName;
        this.surname = personBuilder.surname;
        this.age = personBuilder.age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name) && Objects.equals(surname, person.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age);
    }

    public static class PersonBuilder{
        private String name;
        @Nullable
        private String middleName;
        private String surname;
        private int age;

        public PersonBuilder(String name, String surname, int age) throws InvalidAttributeValueException {
            this.setName(name).setSurname(surname).setAge(age);
        }

        public PersonBuilder() {

        }

        public PersonBuilder setName(String name) throws InvalidAttributeValueException {
            if (name.length() < 2) throw new InvalidAttributeValueException();
            this.name = name;
            return this;
        }

        public PersonBuilder setMiddleName(String middleName) throws InvalidAttributeValueException {
            if (middleName.length() < 2) throw new InvalidAttributeValueException();
            this.middleName = middleName;
            return this;
        }
        public PersonBuilder setSurname(String surname) throws InvalidAttributeValueException {
            if (surname.length() < 2) throw new InvalidAttributeValueException();
            this.surname = surname;
            return this;
        }
        public PersonBuilder setAge(int age) throws InvalidAttributeValueException {
            if (age < 1) throw new InvalidAttributeValueException();
            this.age = age;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }
}
