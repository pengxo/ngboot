package com.pengxo.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JmsMessageReceiver {

	private static final Logger logger = LoggerFactory.getLogger(JmsMessageReceiver.class);

	@JmsListener(destination = "jms.message.endpoint")
	public void receiveMessage(final JmsMessage msg) {
		logger.debug("The successful received jms message is: {}", msg);
	}

}
