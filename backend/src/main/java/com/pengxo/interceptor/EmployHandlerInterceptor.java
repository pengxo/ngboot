package com.pengxo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class EmployHandlerInterceptor implements HandlerInterceptor {

	private static final Logger logger = LoggerFactory.getLogger(EmployHandlerInterceptor.class);

	@Override
	public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler)
			throws Exception {
		logger.debug("Pre Handle method is Calling with method: {}", request.getMethod());
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler,
			final ModelAndView modelAndView) throws Exception {
		logger.debug("Post Handle method is Calling with url: {}", request.getRequestURI());
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(final HttpServletRequest request, final HttpServletResponse response,
			final Object handler, final Exception ex) throws Exception {
		logger.debug("Handle method after completion is Calling:{} ", request.getMethod());
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

}
