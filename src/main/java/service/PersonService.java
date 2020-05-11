package service;

import dao.PersonRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostConstruct
    public void getPersonName() {
        System.out.println(personRepository.getPerson().getName());
    }
}
