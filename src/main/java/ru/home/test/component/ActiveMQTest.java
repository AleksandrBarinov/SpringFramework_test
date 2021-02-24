package ru.home.test.component;

import org.springframework.context.ApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ActiveMQTest {

    private final ApplicationContext context;

    public ActiveMQTest(ApplicationContext context) {
        this.context = context;
    }

    @PostConstruct
    public void testSendMessage() {
        JmsTemplate jms = context.getBean(JmsTemplate.class);
        jms.convertAndSend("foo.bar", "test message 2");
    }
}
