package ru.home.test.service;

import org.springframework.stereotype.Service;
import ru.home.test.component.Properties;
import ru.home.test.dao.PersonRepository;
import ru.home.test.entity.Person;

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
