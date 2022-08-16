package com.khoa.af.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.khoa.af.api.admin.User;
import com.khoa.af.rowmapper.UserRowMapper;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<User> loadUser() {

		String sql = "SELECT * FROM users WHERE deleted=0";

		List<User> theListOfUser = jdbcTemplate.query(sql, new UserRowMapper());

		return theListOfUser;
	}

	@Override
	public void saveUser(User user) {

		Object[] sqlParameters = { user.getUserName(), user.getPassword() };

		String sql = "INSERT INTO users(userName, password) values (?, ?)";

		jdbcTemplate.update(sql, sqlParameters);
	}

	@Override
	public User getUser(int id) {

		String sql = "SELECT * FROM users WHERE userId=?";

		User user = jdbcTemplate.queryForObject(sql, new UserRowMapper(), id);

		return user;
	}

	@Override
	public void update(User user) {

		Object[] sqlParameters = { user.getUserName(), user.getPassword(), user.getUserId() };

		String sql = "UPDATE users SET userName=?, password=? WHERE userId=?";

		jdbcTemplate.update(sql, sqlParameters);
	}

	@Override
	public boolean deleteUser(int id) {

		String sql = "UPDATE users SET deleted=1 WHERE userId=?";

		int affectedRows = jdbcTemplate.update(sql, id);

		return affectedRows == 1;
	}

	@Override
	public User login(String userName, String password) {

		String sql = "SELECT userId, userName FROM users WHERE userName=? AND password=?";

		try {
			User user = jdbcTemplate.queryForObject(sql, new UserRowMapper(), userName, password);

			return user;
			
		} catch (EmptyResultDataAccessException e) {
			
			return null;
		}

	}

}
