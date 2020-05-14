package ru.home.test.service;

import org.springframework.stereotype.Service;
import ru.home.test.dao.PersonRepository;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public String getPersonName() {
        return personRepository.getPerson().getName();
    }
}
