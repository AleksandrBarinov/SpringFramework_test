package ru.home.test.domain.repository;

import org.springframework.data.repository.CrudRepository;
import ru.home.test.domain.model.Person;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {
}
