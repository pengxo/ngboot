package com.pengxo.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.core.JmsTemplate;

import com.pengxo.NgbootApplication;

public class JmsSenderMain {

	private static final Logger logger = LoggerFactory.getLogger(JmsSenderMain.class);

	public static void main(final String[] args) {

		// Launch the application
		final ConfigurableApplicationContext context = SpringApplication.run(NgbootApplication.class, args);

		// Get JMS template bean reference
		final JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);

		// Send a message
		logger.debug("Sending a jms message.");
		jmsTemplate.convertAndSend("jms.message.endpoint", new JmsMessage(1001L, "test body", "info"));

	}

}
