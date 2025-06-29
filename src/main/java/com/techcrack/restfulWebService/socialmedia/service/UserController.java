package com.techcrack.restfulWebService.socialmedia.service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.jboss.logging.Logger;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.techcrack.restfulWebService.socialmedia.data.UserRepository;
import com.techcrack.restfulWebService.socialmedia.entity.User;
import com.techcrack.restfulWebService.socialmedia.exception.UserNotFoundException;

import jakarta.validation.Valid;

@RestController
public class UserController {
	private UserRepository manage;
	
	public UserController(UserRepository manage) {
		this.manage = manage;
	}
	
	@GetMapping("/users")
	@ResponseStatus(HttpStatus.OK)
	public List<User> getAllUsers() {
//		return manage.

		return manage.findAll();
	}
	
	@SuppressWarnings("deprecation")
	@GetMapping("/users/{id}")
	public EntityModel<User> getUser(@PathVariable Integer id) {
		Optional<User> user = manage.findById(id);
		
		Logger.getLogger(getClass()).debug( user + " " + " founded");
		
		if (user == null) {
			throw new UserNotFoundException("User ID " + id + " Not Found");
		}
		
		EntityModel<User> entityModel = EntityModel.of(user.get());
		
		WebMvcLinkBuilder allUsers = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllUsers());
		
		WebMvcLinkBuilder userUnique = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getUser(id));
		
		entityModel.add(allUsers.withRel("all-users"));
		entityModel.add(userUnique.withRel("User with id " + id));
		
		return entityModel;
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> saveUser(@Valid @RequestBody User user) {
		User savedUser = manage.save(user);
	
		URI location = ServletUriComponentsBuilder
							.fromCurrentRequest()
							.path("/{id}")
							.buildAndExpand(savedUser.getId())
							.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("users/{id}")
	public void deleteUser(@PathVariable Integer id) {
		manage.deleteById(id);
	}
}	
