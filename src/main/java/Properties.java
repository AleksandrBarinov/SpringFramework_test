import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Properties {

    @Value("${bean.name}")
    private String beanName;

    public String getBeanName() {
        return beanName;
    }
}
