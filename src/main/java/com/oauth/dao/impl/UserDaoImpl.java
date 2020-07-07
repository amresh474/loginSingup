package com.oauth.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.oauth.dao.UserDao;
import com.oauth.model.User;

@Repository("userDaoImpl")
public class UserDaoImpl implements UserDao {
	@Autowired
	private MongoTemplate template;

	@Override
	public void save(User user) {
		template.save(user);

	}

	@Override
	public List<User> find(String mobile) {

		Query query = new Query();
		query.addCriteria(Criteria.where("mobile").is(mobile));
		return template.find(query, User.class);
	}

	@Override
	public User update(User user, String mobile) {

		Query query = new Query();
		query.addCriteria(Criteria.where("mobile").is(mobile));

		Update update = new Update();
		update.set( "createdbycat", user.getCreatedbycat());
		update.set("firstName", user.getFirstName());
		update.set("lastName", user.getLastName());

		return template.findAndModify(query, update, new FindAndModifyOptions().returnNew(true), User.class);

	}

	@Override
	public void delete(String mobile) {
		Query query = new Query();
		query.addCriteria(Criteria.where("mobile").is(mobile));
		template.remove(query, User.class);

	}

	@Override
	public User partialUpdate(User user, String mobile) {
		Query query = new Query();
		query.addCriteria(Criteria.where("mobile").is(mobile));

		Update update = new Update();
		update.set("firstName", user.getFirstName());
		update.set("lastName", user.getLastName());
		update.set( "updatedbycat", user.getUpdatedbycat());

		return template.findAndModify(query, update, new FindAndModifyOptions().returnNew(true), User.class);
	}

	@Override
	public List<User> getAllUsers() {
		return template.findAll(User.class);
	}

}
