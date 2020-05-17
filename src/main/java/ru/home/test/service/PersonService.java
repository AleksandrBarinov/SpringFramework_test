package ru.home.test.service;

import org.springframework.stereotype.Service;
import ru.home.test.Properties;
import ru.home.test.dao.PersonRepository;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    private boolean customProperty;

    public PersonService(
            PersonRepository personRepository,
            Properties properties
    ) {
        this.personRepository = personRepository;
        this.customProperty = properties.isCustomProperty();
    }

    public String getPersonName() {
        return personRepository.getPerson().getName() + " " + customProperty;
    }
}
