package org.example;

import org.jetbrains.annotations.Nullable;

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
        private final String name;
        @Nullable
        private String middleName;
        private final String surname;
        private final int age;

        public PersonBuilder(String name, String surname, int age) {
            this.name = name.length() >= 2 ? name : "John";
            this.middleName = "Junior";
            this.surname = surname.length() >= 2 ? surname : "Doe";
            this.age = age > 0 ? age : 18;
        }

        public PersonBuilder setMiddleName(String middleName) {
            this.middleName = middleName.length() >= 2 ? middleName : "Junior";
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }
}
