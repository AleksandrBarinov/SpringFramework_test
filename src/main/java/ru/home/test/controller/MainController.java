package ru.home.test.controller;

import javassist.NotFoundException;
import org.springframework.web.bind.annotation.*;
import ru.home.test.controller.pojo.NewUser;
import ru.home.test.entity.Person;
import ru.home.test.service.PersonService;
import ru.home.test.service.UserService;

import java.util.Optional;

@RestController
public class MainController {

    private final PersonService personService;
    private final UserService userService;

    public MainController(PersonService personService, UserService userService) {
        this.personService = personService;
        this.userService = userService;
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

    @PostMapping("addUser")
    public void addUser(@RequestBody NewUser newUser) throws NotFoundException {
        userService.addNewUser(newUser);
    }
}
