import dao.PersonRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import service.PersonService;

//@PropertySource("classpath:application.properties")
@EnableAspectJAutoProxy
@Configuration
public class AppConfig {

    @Bean
    AspectTest aspectTest() {
        return new AspectTest();
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        configurer.setLocation(new ClassPathResource("application.properties"));
        return configurer;
    }

    @Bean
    PersonRepository personRepository() {
        return new PersonRepository();
    }

    @Bean(name = "test")
    PersonService personService(PersonRepository dao) {
        return new PersonService(dao);
    }

    @Bean
    Properties properties() {
        return new Properties();
    }
}
