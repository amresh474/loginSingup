package com.oauth.dao;

import java.util.List;

import com.oauth.model.User;

public interface UserDao {

	public List<User> find(String mobile);

	public User update(User user, String mobile);

	public void delete(String mobile);

	public void save(User user);

	public User partialUpdate(User user, String mobile);

	public List<User> getAllUsers();
}
