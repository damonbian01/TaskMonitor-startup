package com.cstnet.cnnic.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cstnet.cnnic.dao.UserDao;
import com.cstnet.cnnic.service.UserService;

public class UserDaoTestCase {
	private ApplicationContext ctx = null;
	private UserDao userDao = null;
	private UserService userService = null;
	
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		userDao = (UserDao) ctx.getBean("UserDao");
		userService = (UserService) ctx.getBean("UserService");
	}
	
	@Test
	public void testLogin() {
		System.out.println(userService.login(null, null));
		System.out.println(userService.login("damon@cstnet.cn", "damon"));
	}
	
	@Test
	public void testGetUser() {
		System.out.println(userDao.getUser("damon@cstnet.cn", "damon"));
	}
	
}
