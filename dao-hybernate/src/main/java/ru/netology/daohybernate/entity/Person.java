package ru.netology.daohybernate.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "PERSONS")
@IdClass(PersonId.class)
public class Person {

    @Id
    private String name;

    @Id
    private String surname;

    @Id
    private int age;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "city_of_living")
    private String cityOfLiving;
}
