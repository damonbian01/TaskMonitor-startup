package com.cstnet.cnnic.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		TestDbConf dbConf = (TestDbConf) ctx.getBean("test_db");
		System.out.println(dbConf.toString());
	}

}
