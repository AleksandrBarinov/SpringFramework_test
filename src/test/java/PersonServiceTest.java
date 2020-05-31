import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ru.home.test.Main;
import ru.home.test.component.Properties;
import ru.home.test.dao.PersonRepository;
import ru.home.test.entity.Person;
import ru.home.test.service.PersonService;

import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Main.class)
public class PersonServiceTest {

    @Autowired
    private PersonService personService;

    @MockBean
    private static PersonRepository personRepository;

    @MockBean
    private static Properties properties;

    @TestConfiguration
    static class PersonServiceContextConfiguration {

        @Bean
        public PersonService personService() {
            return new PersonService(personRepository,properties);
        }
    }

    @Before
    public void setUp() {
        Person person = new Person();
        person.setId(5);
        person.setName("test_record");
        Optional<Person> optionalPerson = Optional.of(person);
        Mockito.when(personRepository.findById(5)).thenReturn(optionalPerson);
    }

    @Test
    public void test() {
        Optional<Person> person = personService.getPerson(5);
        if (person.isPresent()) {
            Assert.assertEquals("test_record", person.get().getName());
        } else {
            throw new AssertionError("person is not present");
        }
    }
}
