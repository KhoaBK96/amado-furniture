package com.khoa.af.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khoa.af.api.admin.User;
import com.khoa.af.dao.UserDAO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;

	@Override
	public List<User> loadUser() {

		return userDAO.loadUser();
	}

	@Override
	public void saveUser(User user) {

		userDAO.saveUser(user);

	}

	@Override
	public User getUser(int id) {

		return userDAO.getUser(id);
	}

	@Override
	public void update(User user) {
		
		userDAO.update(user);
		
	}

	@Override
	public boolean deleteUser(int id) {

		return userDAO.deleteUser(id);
		
	}

	@Override
	public User login(String userName, String password) {
		return userDAO.login(userName, password);
	}

}
