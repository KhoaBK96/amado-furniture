package com.khoa.af.service;

import java.util.List;

import com.khoa.af.api.admin.User;

public interface UserService {
	
	List<User> loadUser();
	
	void saveUser(User user);

	User getUser(int id);

	void update(User user);

	boolean deleteUser(int id);
	
	User login(String userName, String password);

}
