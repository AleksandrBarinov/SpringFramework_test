import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.PersonService;

public class Main {

    public static void main(String[] args) {

//        ClassPathXmlApplicationContext context =
//                new ClassPathXmlApplicationContext("/ApplicationContext.xml");
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        PersonService service = context.getBean(PersonService.class);

        System.out.println(service.getPersonName());
    }
}
