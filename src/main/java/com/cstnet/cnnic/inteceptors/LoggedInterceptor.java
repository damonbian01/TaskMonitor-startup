package com.cstnet.cnnic.inteceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cstnet.cnnic.conf.SystemCons;
import com.cstnet.cnnic.po.User;

public class LoggedInterceptor implements HandlerInterceptor {

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println(this.getClass().getName()+":preHandle()");
		/*encode control*/
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		/*determine whehther use is logged*/
		HttpSession session = request.getSession();
		User currentUser = (User) session.getAttribute(SystemCons.admin);
		String requestUrl = request.getRequestURI().toString();

		System.out.println("INFO:"+this.getClass().getName()+":preHandle()"+":url="+requestUrl);
		if (currentUser == null) {
			response.sendRedirect(request.getContextPath()+"/index");
			return false;
		}
		return true;
	}

	
	
}
