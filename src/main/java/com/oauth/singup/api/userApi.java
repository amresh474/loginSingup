package com.oauth.singup.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oauth.model.User;
import com.oauth.service.UserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping
public class userApi {

	@Autowired
	private UserService userService;

	@PostMapping("/user")
	public User save(@RequestBody User user) {
		userService.save(user);
		return user;
	}
	
	@GetMapping(value="/user")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	@GetMapping(value = "/user/{mobile}")
	public List<User> find(@PathVariable String mobile) {
		return userService.find(mobile);
	}

	@PutMapping(value = "/user/{mobile}")
	public User update(@RequestBody User user, @PathVariable String mobile) {
		return userService.update(user, mobile);
	}

	@PatchMapping(value = "/user/{mobile}")
	public User partialUpdate(@RequestBody User user, @PathVariable String mobile) {
		return userService.partialUpdate(user, mobile);
	}

	@DeleteMapping("/user/{mobile}")
	public String deleteuser(@PathVariable String mobile) {
		userService.delete(mobile);
		return "sfull";
	}

}
