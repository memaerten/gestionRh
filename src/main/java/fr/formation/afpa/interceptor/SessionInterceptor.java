package fr.formation.afpa.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SessionInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	HttpSession session;
	
	private static final long MAX_INACTIVE_SESSION_TIME = 5 * 10000;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("------------ LogInterceptor preHandle()");
		long startTime = System.currentTimeMillis();
		request.setAttribute("execTime", startTime);
		if (UserInterceptor.isLogged()) {
		    session = request.getSession();
		    if (System.currentTimeMillis() - session.getLastAccessedTime()
		      > MAX_INACTIVE_SESSION_TIME) {
		        SecurityContextHolder.clearContext();
		        request.logout();
		        response.sendRedirect("/deconnexion");
		    }
		}
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("------------ LogInterceptor postHandle()");
		System.out.println("Request URL : " + request.getRequestURL());
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("------------ LogInterceptor afterCompletion()");
		System.out.println("");
	}
	
}
