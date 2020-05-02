import dao.PersonRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import service.PersonService;

@Configuration
public class AppConfig {

    @Bean
    PersonRepository personRepository() {
        return new PersonRepository();
    }

    @Bean
    PersonService personService(PersonRepository dao) {
        return new PersonService(dao);
    }
}
