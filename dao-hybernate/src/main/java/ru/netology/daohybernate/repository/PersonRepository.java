package ru.netology.daohybernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.netology.daohybernate.entity.Person;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, String> {

    // Получить всех людей из указанного города
    List<Person> findByCityOfLiving(String city);

    // Найти всех людей, чей возраст меньше указанного, отсортировать по возрасту
    List<Person> findByAgeLessThanOrderByAgeAsc(int age);

    // Найти человека по имени и фамилии
    @Query("SELECT p FROM Person p WHERE p.name = :name AND p.surname = :surname")
    Optional<Person> findByNameAndSurname(String name, String surname);
}
