package ru.home.test.service;

import org.springframework.stereotype.Service;
import ru.home.test.config.Properties;
import ru.home.test.domain.repository.PersonRepository;
import ru.home.test.domain.model.Person;

import java.util.Optional;

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

    public int addNewPerson(Person person) {
        return personRepository.save(person).getId();
    }

    public Optional<Person> getPerson(Integer id) {
        return personRepository.findById(id);
    }
}
