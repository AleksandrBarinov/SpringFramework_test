package ru.home.test.controller;

import javassist.NotFoundException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.home.test.service.dto.UserDto;
import ru.home.test.domain.model.Person;
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
    @PreAuthorize("hasAnyAuthority('admin','user')")
    public int add(@RequestBody Person person) {
        return personService.addNewPerson(person);
    }

    @GetMapping("getPerson")
    @PreAuthorize("hasAnyAuthority('admin','user')")
    public Person get(@RequestParam Integer id) {
        Optional<Person> person = personService.getPerson(id);
        return person.orElse(null);
    }

    @PreAuthorize("hasAuthority('admin')")
    @PostMapping("addUser")
    public void addUser(@RequestBody UserDto userDto) throws NotFoundException {
        userService.addNewUser(userDto);
    }
}
