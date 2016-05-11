package com.cstnet.cnnic.dao;

import com.cstnet.cnnic.po.User;

/**
 * operate actions with table user
 * @author Tao Bian 2016/05/11
 *
 */
public interface UserDao {

	public User getUser(String email, String passwd);
	
}
