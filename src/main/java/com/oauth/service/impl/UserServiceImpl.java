package com.oauth.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oauth.dao.UserDao;
import com.oauth.model.User;
import com.oauth.service.UserService;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public void save(User user) {
		userDao.save(user);

	}

	@Override
	public List<User> find(String mobile) {
		return userDao.find(mobile);
	}

	@Override
	public User update(User user, String mobile) {
		return userDao.update(user, mobile);
	}

	@Override
	public User partialUpdate(User user, String mobile) {
		return userDao.partialUpdate(user, mobile);
	}

	@Override
	public void delete(String mobile) {
		userDao.delete(mobile);

	}

	
	@Override
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

}
