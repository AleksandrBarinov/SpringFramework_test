package ru.home.test.dao;

import ru.home.test.entity.Person;
import org.springframework.stereotype.Repository;

@Repository
public class PersonRepository {

    public Person getPerson() {
        Person person = new Person();
        person.setName("Ivan");
        return person;
    }
}
