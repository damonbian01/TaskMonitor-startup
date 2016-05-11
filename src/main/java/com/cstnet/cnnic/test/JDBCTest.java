package com.cstnet.cnnic.test;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.cstnet.cnnic.po.User;

public class JDBCTest {

	public static void main(String[] args) throws SQLException {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		DataSource dataSources = ctx.getBean(DataSource.class);
		JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("JdbcTemplate");
		System.out.println(dataSources.getConnection());
//		testQueryForObject(jdbcTemplate);
//		testBatchInert(jdbcTemplate);
		testQueryList(jdbcTemplate);
	}
	
	public static void testQueryForObject(JdbcTemplate jdbcTemplate) {
		String sql = "SELECT id, name, pwd as passwd, email from t_user where id = ?";
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
		User user = jdbcTemplate.queryForObject(sql, rowMapper, 1);
		System.out.println(user.toString());
	}
	
	/**
	 * batch update insert delete
	 */
	public static void testBatchInert(JdbcTemplate jdbcTemplate) {
		String sql = "INSERT into t_user values (?,?,?,?) ";
		ArrayList<Object[]> batchArgs = new ArrayList<Object[]>();
		batchArgs.add(new Object[]{2,"damon","damon","damon@cstnet.cn"});
		batchArgs.add(new Object[]{3,"damon3","damon3","damon3@cstnet.cn"});
		batchArgs.add(new Object[]{4,"damon4","damon4","damon4@cstnet.cn"});
		jdbcTemplate.batchUpdate(sql, batchArgs);
	}
	
	/**
	 * query list
	 */
	public static void testQueryList(JdbcTemplate jdbcTemplate) {
		String sql = "SELECT id, name, email FROM t_user WHERE name like '%damon%'";
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
		ArrayList<User> users = (ArrayList<User>) jdbcTemplate.query(sql, rowMapper);
		
		System.out.println(users.toString());
	}

}
