package ru.netology.daohybernate.controller;

import ru.netology.daohybernate.entity.Person;
import ru.netology.daohybernate.repository.PersonRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/persons/by-city")
    public List<Person> getPersonsByCity(@RequestParam("city") String city) {
        return personRepository.getPersonsByCity(city);
    }
}
