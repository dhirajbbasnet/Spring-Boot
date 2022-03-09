package com.dhiraj.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public boolean validateUser(String username, String password) {
		String sql = "select username from users where username = ? and password = ?";
		Object[] data = { username, password };

		List<String> users = jdbcTemplate.queryForList(sql, data, String.class);
		return users.size() != 0; // if size is not zero, user exists
	}
}
