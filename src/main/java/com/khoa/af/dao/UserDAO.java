package com.khoa.af.dao;

import java.util.List;

import com.khoa.af.api.admin.User;

public interface UserDAO {
	
	List<User> loadUser();
	
	void saveUser(User user);
	
	User getUser(int id);
	
	void update(User user);
	
	boolean deleteUser(int id);
	
	User login(String userName, String password);

}
