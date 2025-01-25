package ru.netology.daohybernate.entity;

import java.io.Serializable;
import java.util.Objects;

public class PersonId implements Serializable {

    private String name;
    private String surname;
    private int age;

    public PersonId() {
    }

    public PersonId(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonId personId = (PersonId) o;
        return age == personId.age &&
                Objects.equals(name, personId.name) &&
                Objects.equals(surname, personId.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age);
    }
}
