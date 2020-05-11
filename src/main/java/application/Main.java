package application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import service.PersonService;

@ComponentScan(value = "service")
@ComponentScan(value = "dao")
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

//        ClassPathXmlApplicationContext context =
//                new ClassPathXmlApplicationContext("/ApplicationContext.xml");
//        AnnotationConfigApplicationContext context =
//                new AnnotationConfigApplicationContext(AppConfig.class);
//
//        Properties properties = context.getBean(Properties.class);
//        String beanNameFromPropertyFile = properties.getBeanName();

//        PersonService service = (PersonService) context.getBean(beanNameFromPropertyFile);

//        System.out.println(service.getPersonName());
    }
}
