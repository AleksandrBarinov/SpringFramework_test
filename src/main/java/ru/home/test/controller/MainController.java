package ru.home.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.home.test.service.PersonService;

@RestController
public class MainController {

    private final PersonService personService;

    public MainController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("test")
    public String test(@RequestParam Integer id) {
        return personService.getPersonName() + " " + id;
    }
}
