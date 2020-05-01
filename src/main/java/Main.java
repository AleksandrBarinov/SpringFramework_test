import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.PersonService;

public class Main {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("/ApplicationContext.xml");

        PersonService service = context.getBean(PersonService.class);

        System.out.println(service.getPersonName());
    }
}
