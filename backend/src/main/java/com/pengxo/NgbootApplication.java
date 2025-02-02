package com.pengxo;

import com.pengxo.configproperties.EmployeeProperties;
import com.pengxo.profile.ProfileInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableJms
@EnableScheduling
@EnableSwagger2
@EnableRetry
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

    @Scheduled(fixedRate = 300000)
    public static void executeScheduledTask() {
        logger.debug("This is a scheduled task executed every 300 seconds. in thread: {}",
                Thread.currentThread().getName());
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
