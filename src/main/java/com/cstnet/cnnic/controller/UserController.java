package com.cstnet.cnnic.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.mvc.support.ControllerBeanNameHandlerMapping;

import com.cstnet.cnnic.conf.SystemCons;
import com.cstnet.cnnic.po.User;
import com.cstnet.cnnic.service.UserService;

/**
 * method 1: configure by annotation method 2: extends
 * 
 * @author Tao Bian 2016/05/10
 *
 */
public class UserController extends AbstractController {

	@Autowired
	@Qualifier("UserService")
	private UserService userService;
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println(this.getClass().getName()+":ModelAndView()");
		/* response return int 1 means login succ else fail */
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		
		String email = (String) request.getParameter("username");
		String userpwd = (String) request.getParameter("userpwd");
		System.out.println("username:"+email+" passwd:"+userpwd+" logged");
		
		/*login*/
		User admin = userService.login(email, userpwd);
		if (admin != null) {
			HttpSession session = request.getSession();
			session.setAttribute(SystemCons.admin, admin);
			writer.print(1);
		} else
			writer.print(0);
		writer.close();
		return null;
	}

}
