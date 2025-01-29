package ru.netology.daohybernate.controller;

import org.springframework.web.bind.annotation.*;
import ru.netology.daohybernate.entity.Person;
import ru.netology.daohybernate.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    // Получить всех людей из указанного города
    @GetMapping("/by-city")
    public List<Person> getPersonsByCity(@RequestParam String city) {
        return personRepository.findByCityOfLiving(city);
    }

    // Получить всех людей младше указанного возраста
    @GetMapping("/by-age")
    public List<Person> getPersonsByAge(@RequestParam int age) {
        return personRepository.findByAgeLessThanOrderByAgeAsc(age);
    }

    // Получить человека по имени и фамилии
    @GetMapping("/by-name-and-surname")
    public Optional<Person> getPersonByNameAndSurname(@RequestParam String name, @RequestParam String surname) {
        return personRepository.findByNameAndSurname(name, surname);
    }

    // CRUD операции
    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        return personRepository.save(person);
    }

    @PutMapping("/{id}")
    public Person updatePerson(@PathVariable String id, @RequestBody Person person) {
        return personRepository.save(person);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable String id) {
        personRepository.deleteById(id);
    }

    @GetMapping("/{id}")
    public Optional<Person> getPersonById(@PathVariable String id) {
        return personRepository.findById(id);
    }
}
