package xo.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableJms
@EnableScheduling
public class NgbootApplication {

	public static void main(final String[] args) {
		final ConfigurableApplicationContext context = SpringApplication.run(NgbootApplication.class, args);
		context.registerShutdownHook();
		executeScheduledTask();
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Scheduled(fixedRate = 30000)
	public static void executeScheduledTask() {
		System.out.println(
				"This is a scheduled task executed every 30 seconds. in thread: " + Thread.currentThread().getName());

	}
}
