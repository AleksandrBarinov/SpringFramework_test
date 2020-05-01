package service;

import dao.PersonRepository;

public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public String getPersonName() {
        return personRepository.getPerson().getName();
    }
}
