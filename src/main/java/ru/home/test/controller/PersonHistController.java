package ru.home.test.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.home.test.domain.model.Person;
import ru.home.test.domain.revision.Revision;
import ru.home.test.service.api.HistService;
import ru.home.test.service.dto.HistStateDto;

import java.util.List;

/**
 * Controller for getting historical states of Person entity {@link Person}.
 *
 * @author Aleksandr Barinov
 */
@RestController
public class PersonHistController {

    private final HistService<Person, Revision> service;

    /**
     * Constructor.
     *
     * @param service PersonHistService
     */
    public PersonHistController(HistService<Person, Revision> service) {
        this.service = service;
    }

    /**
     * Getting full information of entity states.
     *
     * @param id Entity id
     * @return List of entity states as {@link HistStateDto}
     */
    @GetMapping("personHist")
    @PreAuthorize("hasAnyAuthority('admin','user')")
    public List<HistStateDto<Person, Revision>> getStates(@RequestParam Integer id) {
        return service.getRevisionsById(id);
    }
}
