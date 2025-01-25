package ru.netology.daohybernate.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.netology.daohybernate.entity.Person;

import java.util.List;

@Repository
public class PersonRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> getPersonsByCity(String city) {
        String query = "SELECT p FROM Person p WHERE p.cityOfLiving = :city";
        return entityManager.createQuery(query, Person.class)
                .setParameter("city", city)
                .getResultList();
    }
}
