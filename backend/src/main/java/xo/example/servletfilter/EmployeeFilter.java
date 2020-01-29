package xo.example.servletfilter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.stereotype.Component;

@Component
public class EmployeeFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("Filter is destroyed.");
	}

	@Override
	public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Filter for protocol:" + request.getProtocol() + "; chain is: " + chain.getClass());
		chain.doFilter(request, response);

	}

	@Override
	public void init(final FilterConfig filterConfig) throws ServletException {
		System.out
				.println("Filter is initialized with server info: " + filterConfig.getServletContext().getServerInfo());
	}

}
