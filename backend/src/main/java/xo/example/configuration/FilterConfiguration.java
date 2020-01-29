package xo.example.configuration;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import xo.example.servletfilter.EmployeeFilter;

@Configuration
public class FilterConfiguration {

	@Bean
	public FilterRegistrationBean<EmployeeFilter> loggingFilter() {
		final FilterRegistrationBean<EmployeeFilter> registrationBean = new FilterRegistrationBean<>();

		registrationBean.setFilter(new EmployeeFilter());

		registrationBean.addUrlPatterns("/employees");

		return registrationBean;

	}
}
