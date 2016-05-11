package com.cstnet.cnnic.test;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.cstnet.cnnic.po.User;

public class JDBCTestCase {
	private ApplicationContext ctx = null;
	JdbcTemplate jdbcTemplate = null;
	DataSource dataSources = null;
	SessionFactory sessionFactory = null;
	
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		dataSources = (DataSource) ctx.getBean("dataSource");
		sessionFactory = (SessionFactory) ctx.getBean("sessionFactory");
//		jdbcTemplate = (JdbcTemplate) ctx.getBean("JdbcTemplate");
	}
	
	@Test
	public void TestConnection() {
		try {
			System.out.println(dataSources.getConnection());;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSessionFactory() {
		System.out.println(sessionFactory.toString());
	}
	
	@Test
	public void testQueryForObject() {
		String sql = "SELECT id, name, pwd as passwd, email from t_user where id = ?";
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
		User user = jdbcTemplate.queryForObject(sql, rowMapper, 1);
		System.out.println(user.toString());
	}
	
	@Test
	public void testBatchInert() {
		String sql = "INSERT into t_user values (?,?,?,?) ";
		ArrayList<Object[]> batchArgs = new ArrayList<Object[]>();
		batchArgs.add(new Object[]{2,"damon","damon","damon@cstnet.cn"});
		batchArgs.add(new Object[]{3,"damon3","damon3","damon3@cstnet.cn"});
		batchArgs.add(new Object[]{4,"damon4","damon4","damon4@cstnet.cn"});
		jdbcTemplate.batchUpdate(sql, batchArgs);
	}
	
	@Test
	public void testQueryList() {
		String sql = "SELECT id, name, email FROM t_user WHERE name like '%damon%'";
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
		ArrayList<User> users = (ArrayList<User>) jdbcTemplate.query(sql, rowMapper);
		System.out.println(users.toString());
	}

}
