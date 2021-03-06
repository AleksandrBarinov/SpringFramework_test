package ru.home.test.service;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.home.test.domain.model.Person;
import ru.home.test.domain.repository.PersonRepository;
import ru.home.test.mapper.PersonMapper;
import ru.home.test.service.dto.PersonDto;

import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    private final PersonMapper mapper = Mappers.getMapper(PersonMapper.class);

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional
    public int addNewPerson(PersonDto personDto) {
        return personRepository.save(mapper.toModel(personDto)).getId();
    }

    @Transactional
    public String editPerson(PersonDto personDto) {
        Optional<Person> person = personRepository.findById(personDto.getId());

        if (person.isPresent()) {
            personRepository.save(mapper.toModel(personDto));
            return person.get().getName() + " edited";
        } else {
            return "person not found";
        }
    }

    @Transactional
    public String deletePerson(Integer id) {
        Optional<Person> person = personRepository.findById(id);

        if (person.isPresent()) {
            personRepository.delete(person.get());
            return person.get().getName() + " deleted";
        } else {
            return "person not found";
        }
    }

    @Transactional(readOnly = true)
    public PersonDto getPerson(Integer id) {
        Optional<Person> person = personRepository.findById(id);
        return person.map(mapper::toDto).orElse(null);
    }
}
