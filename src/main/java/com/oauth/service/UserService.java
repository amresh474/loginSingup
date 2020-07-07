package com.oauth.service;

import java.util.List;

import com.oauth.model.User;

public interface UserService {

	public void save(User user);

	public List<User> find(String mobile);

	public User update(User user, String mobile);

	public User partialUpdate(User user, String mobile);

	public void delete(String mobile);
	
	

	public List<User> getAllUsers();

}
