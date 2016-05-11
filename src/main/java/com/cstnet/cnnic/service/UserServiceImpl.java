package com.cstnet.cnnic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cstnet.cnnic.dao.UserDao;
import com.cstnet.cnnic.po.User;

@Service("UserService")
public class UserServiceImpl implements UserService {

	@Autowired
	@Qualifier("UserDao")
	private UserDao userDao;

	public User login(String email, String passwd) {
		return userDao.getUser(email, passwd);
	}
	
	
	
}
