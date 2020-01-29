package xo.example.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class EmployHandlerInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler)
			throws Exception {
		System.out.println("Pre Handle method is Calling with method: " + request.getMethod());
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler,
			final ModelAndView modelAndView) throws Exception {
		System.out.println("Post Handle method is Calling with url: " + request.getRequestURI());
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(final HttpServletRequest request, final HttpServletResponse response,
			final Object handler, final Exception ex) throws Exception {
		System.out.println("Handle method after completion is Calling: " + request.getMethod());
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

}
