import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.PersonService;

public class Main {

    public static void main(String[] args) {

//        ClassPathXmlApplicationContext context =
//                new ClassPathXmlApplicationContext("/ApplicationContext.xml");
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        Properties properties = context.getBean(Properties.class);
        String beanNameFromPropertyFile = properties.getBeanName();

        PersonService service = (PersonService) context.getBean(beanNameFromPropertyFile);

        System.out.println(service.getPersonName());
    }
}
