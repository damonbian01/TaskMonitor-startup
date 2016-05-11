package com.cstnet.cnnic.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cstnet.cnnic.po.User;

@Repository("UserDao")
public class UserDaoImpl implements UserDao {
	
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Transactional
	public User getUser(String email, String passwd) {
		String hql = "From User user where user.email = ? and user.passwd = ?";
		Query query = getSession().createQuery(hql);
		query.setString(0, email);
		query.setString(1, passwd);
		List<User> users = query.list();
		return users.size() > 0 ? users.get(0) : null;
	}

}
