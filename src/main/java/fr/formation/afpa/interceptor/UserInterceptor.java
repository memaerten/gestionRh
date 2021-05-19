package fr.formation.afpa.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.SmartView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class UserInterceptor extends HandlerInterceptorAdapter {

	private static final Log log = LogFactory.getLog(UserInterceptor.class);

	public static boolean isLogged() {
		try {
			System.out.println(SecurityContextHolder.getContext().getAuthentication().getName().equals("root"));
			return !SecurityContextHolder.getContext().getAuthentication().getName().equals("root");
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object object) throws Exception {
		if (isLogged()) {
			addToModelUserDetails(request.getSession());
		}
		return true;
	}

	private void addToModelUserDetails(HttpSession session) {
		String loggedUsername  = SecurityContextHolder.getContext().getAuthentication().getName();
		session.setAttribute("username", loggedUsername);

		log.info("user(" + loggedUsername + ") session : " + session + " addToModelUserDetails");
	}

	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse res, Object o, ModelAndView model) throws Exception {

		if (model != null && !isRedirectView(model)) {
			if (isLogged()) {
				addToModelUserDetails(model);
			}
		}
	}

	public static boolean isRedirectView(ModelAndView mv) {
		String viewName = mv.getViewName();
		if (viewName.startsWith("redirect:/")) {
			return true;
		}
		View view = mv.getView();
		return (view != null && view instanceof SmartView
				&& ((SmartView) view).isRedirectView());
	}
	
	private void addToModelUserDetails(ModelAndView model) {
	    String loggedUsername = SecurityContextHolder.getContext()
	      .getAuthentication().getName();
	    model.addObject("loggedUsername", loggedUsername);

	}
}
