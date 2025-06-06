package com.techcrack.restfulWebService.socialmedia.service;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.techcrack.restfulWebService.socialmedia.data.UserDaoManage;
import com.techcrack.restfulWebService.socialmedia.entity.User;

@RestController
public class UserController {
	private UserDaoManage manage;
	
	public UserController(UserDaoManage manage) {
		this.manage = manage;
	}
	
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return manage.findAllUser();
	}
	
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable Integer id) {
		return manage.findOne(id);
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		User savedUser = manage.saveUser(user);
	
		URI location = ServletUriComponentsBuilder
							.fromCurrentRequest()
							.path("/{id}")
							.buildAndExpand(savedUser.getId())
							.toUri();
		
		return ResponseEntity.created(location).build();
	}
}	
