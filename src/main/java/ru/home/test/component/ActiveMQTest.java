package ru.home.test.component;

import org.apache.activemq.command.ActiveMQTextMessage;
import org.apache.activemq.util.ByteSequence;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.jms.Message;

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

    @PostConstruct
    public void testReceiveMessage() {
        JmsTemplate jms = context.getBean(JmsTemplate.class);
        Message message = jms.receive("foo.bar.incoming");

        assert message != null;
        ByteSequence bytes = ((ActiveMQTextMessage) message).getContent();
        String stringMessage = new String(bytes.data);

        System.out.println(stringMessage);
    }
}
