package ru.home.test.controller;

import org.springframework.web.bind.annotation.*;
import ru.home.test.entity.Person;
import ru.home.test.service.PersonService;

import java.util.Optional;

@RestController
public class MainController {

    private final PersonService personService;

    public MainController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("addPerson")
    public int add(@RequestBody Person person) {
        return personService.addNewPerson(person);
    }

    @GetMapping("getPerson")
    public Person get(@RequestParam Integer id) {
        Optional<Person> person = personService.getPerson(id);
        return person.orElse(null);
    }
}
