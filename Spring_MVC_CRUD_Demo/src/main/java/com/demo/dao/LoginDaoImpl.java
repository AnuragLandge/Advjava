package com.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.beans.MyUser;

@Repository
public class LoginDaoImpl implements LoginDao {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public MyUser authenticateUser(String uname, String passwd) {
		try {
			MyUser user = jdbcTemplate.queryForObject("select * from myuser where uname=? and password=?",
					new Object[] { uname, passwd }, new BeanPropertyRowMapper<>(MyUser.class));
			return user;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

}
