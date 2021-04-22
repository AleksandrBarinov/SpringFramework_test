package ru.home.test.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.home.test.domain.model.Person;
import ru.home.test.service.PersonService;
import ru.home.test.service.dto.PersonDto;

import java.util.Optional;

@RestController
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("addPerson")
    @PreAuthorize("hasAnyAuthority('admin','user')")
    public int add(@RequestBody PersonDto person) {
        return personService.addNewPerson(person);
    }

    @PutMapping("editPerson")
    @PreAuthorize("hasAnyAuthority('admin','user')")
    public String edit(@RequestBody PersonDto person) {
        return personService.editPerson(person);
    }

    @DeleteMapping("deletePerson")
    @PreAuthorize("hasAnyAuthority('admin','user')")
    public String delete(@RequestParam Integer id) {
        return personService.deletePerson(id);
    }

    @GetMapping("getPerson")
    @PreAuthorize("hasAnyAuthority('admin','user')")
    public PersonDto get(@RequestParam Integer id) {
        return personService.getPerson(id);
    }
}
