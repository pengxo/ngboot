package xo.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import xo.example.interceptor.EmployHandlerInterceptor;

@Component
public class SpringBootAppConfig implements WebMvcConfigurer {

	@Autowired
	EmployHandlerInterceptor employHandlerInterceptor;

	@Override
	public void addInterceptors(final InterceptorRegistry registry) {
		registry.addInterceptor(employHandlerInterceptor);
	}

}
