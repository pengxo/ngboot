package com.pengxo.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class EmployeeSubscriber implements ApplicationListener<EmployeeEvent> {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeSubscriber.class);

	@Override
	public void onApplicationEvent(final EmployeeEvent event) {
		logger.debug("Spring event with type: {}", event.getType());
	}

}
