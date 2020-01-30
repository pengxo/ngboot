package xo.example.jms;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.core.JmsTemplate;

import xo.example.NgbootApplication;

public class JmsSenderMain {

	public static void main(final String[] args) {

		// Launch the application
		final ConfigurableApplicationContext context = SpringApplication.run(NgbootApplication.class, args);

		// Get JMS template bean reference
		final JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);

		// Send a message
		System.out.println("Sending a message.");
		jmsTemplate.convertAndSend("jms.message.endpoint", new JmsMessage(1001L, "test body", "info"));

	}

}
