package org.example;

import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class Person {
    private final String name;
    @Nullable
    private final String middleName;
    private final String surname;
    private final int age;

    private Person(PersonBuilder personBuilder) {
        if (personBuilder.name == null || personBuilder.surname == null) {
            throw new InvalidPersonVariableValueException("Name or Surname is null.");
        }
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

    public String getMiddleName() {
        return middleName;
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", middleName='" + middleName + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }

    public static class PersonBuilder{

        private static final int MIN_STRING_LENGTH = 2;
        private static final int MIN_AGE = 1;
        private String name;
        @Nullable
        private String middleName;
        private String surname;
        private int age;

        public PersonBuilder(Person person) {
            this.name = person.name;
            this.middleName = person.middleName;
            this.surname = person.surname;
            this.age = person.age;
        }

        public PersonBuilder() {

        }

        public PersonBuilder withName(String name) {
            if (name == null || name.length() < MIN_STRING_LENGTH) throw new InvalidPersonVariableValueException("Invalid Name");
            this.name = name;
            return this;
        }

        public PersonBuilder withMiddleName(String middleName) {
            if (middleName != null) {
                if (middleName.length() < MIN_STRING_LENGTH) throw new InvalidPersonVariableValueException("Invalid Name");
                this.middleName = middleName;
            }
            return this;
        }
        public PersonBuilder withSurname(String surname)  {
            if (surname == null || surname.length() < MIN_STRING_LENGTH) throw new InvalidPersonVariableValueException("Invalid Surname");
            this.surname = surname;
            return this;
        }
        public PersonBuilder withAge(int age) {
            if (age < MIN_AGE) throw new InvalidPersonVariableValueException("Invalid age");
            this.age = age;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

    public static Person.PersonBuilder builder() {
        return new PersonBuilder();
    }
}
