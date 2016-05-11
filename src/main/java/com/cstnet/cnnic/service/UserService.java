package com.cstnet.cnnic.service;

import com.cstnet.cnnic.po.User;

public interface UserService {
	
	public User login(String email, String passwd);

}
