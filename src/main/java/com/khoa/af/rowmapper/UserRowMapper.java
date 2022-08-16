package com.khoa.af.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.khoa.af.api.admin.User;

public class UserRowMapper implements org.springframework.jdbc.core.RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		User user = new User();
		
		//userId, userName, password
		user.setUserId(rs.getInt("userId"));
		user.setUserName(rs.getString("userName"));
		
		
		return user;
	}

}
