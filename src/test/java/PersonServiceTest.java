import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ru.home.test.Main;
import ru.home.test.domain.repository.PersonRepository;
import ru.home.test.domain.model.Person;
import ru.home.test.service.PersonService;
import ru.home.test.service.dto.PersonDto;

import java.util.Optional;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Main.class)
public class PersonServiceTest {

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void test() {

        //create person
        PersonDto personDto = new PersonDto();
        personDto.setName("pumpkin");
        personDto.setAge(31);

            int personId = personService.addNewPerson(personDto);

            Optional<Person> foundPerson = personRepository.findById(personId);
            Assert.assertTrue(foundPerson.isPresent());

        //edit person
        Person editedPerson = foundPerson.get();
        editedPerson.setAge(32);
        editedPerson.setName("edited pumpkin");

            personRepository.save(editedPerson);

            Optional<Person> foundEditedPerson = personRepository.findById(personId);
            Assert.assertTrue(foundEditedPerson.isPresent());

            Assert.assertEquals(foundEditedPerson.get().getName(), "edited pumpkin");
            Assert.assertEquals(foundEditedPerson.get().getAge(), 32);

        //delete person
        personRepository.delete(foundPerson.get());

            Optional<Person> foundDeletedPerson = personRepository.findById(personId);
            Assert.assertFalse(foundDeletedPerson.isPresent());
    }
}
