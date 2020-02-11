package com.pengxo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import com.pengxo.configproperties.EmployeeProperties;
import com.pengxo.profile.ProfileInterface;

@SpringBootApplication
@EnableJms
@EnableScheduling
public class NgbootApplication {

	private static final Logger logger = LoggerFactory.getLogger(NgbootApplication.class);

	public static void main(final String[] args) {
		final ConfigurableApplicationContext context = SpringApplication.run(NgbootApplication.class, args);
		context.registerShutdownHook();
		executeScheduledTask();

		final EmployeeProperties bean = context.getBean(EmployeeProperties.class);
		final ProfileInterface profileBean = context.getBean(ProfileInterface.class);

		logger.debug("The property bean is: {}", bean);
		logger.debug("The controller bean is: {}", profileBean);

	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Scheduled(fixedRate = 300000)
	public static void executeScheduledTask() {
		logger.debug("This is a scheduled task executed every 300 seconds. in thread: {}",
				Thread.currentThread().getName());
	}
}
