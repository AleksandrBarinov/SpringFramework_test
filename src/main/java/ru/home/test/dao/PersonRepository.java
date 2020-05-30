package ru.home.test.dao;

import org.springframework.data.repository.CrudRepository;
import ru.home.test.entity.Person;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {
}
