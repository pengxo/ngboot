package com.pengxo.servletfilter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class EmployeeFilter implements Filter {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeFilter.class);

	@Override
	public void destroy() {
		logger.debug("Filter is destroyed.");
	}

	@Override
	public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain)
			throws IOException, ServletException {
		logger.debug("Filter for protocol: {}; chain is: {}", request.getProtocol(), chain.getClass());
		chain.doFilter(request, response);

	}

	@Override
	public void init(final FilterConfig filterConfig) throws ServletException {
		logger.debug("Filter is initialized with server info: {}", filterConfig.getServletContext());
	}

}
