package com.techcrack.restfulWebService.socialmedia.service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.techcrack.restfulWebService.socialmedia.data.PostRepository;
import com.techcrack.restfulWebService.socialmedia.data.UserRepository;
import com.techcrack.restfulWebService.socialmedia.entity.Post;
import com.techcrack.restfulWebService.socialmedia.entity.User;
import com.techcrack.restfulWebService.socialmedia.exception.UserNotFoundException;

@RestController
public class PostController {
	
	@Autowired
	private PostRepository rep;
	
	@Autowired
	private UserRepository ser;
	
	// Using User Repo for Operation
	@GetMapping("/users/{id}/posts")
	public List<Post> retrieveAllPosts(@PathVariable Integer id) {
		Optional<User> user = ser.findById(id);
		
		if (user.isEmpty()) {
			throw new UserNotFoundException("Invalid Id for user " + id);
		}
		
		return user.get().getPosts();
	}
	
//	@PostMapping("/users/{id}/posts")
//	@Transactional
//	public void savePost(@PathVariable Integer id, @RequestBody Post post) {
//		Optional<User> user = ser.findById(id);
//		
//		if (user.isEmpty()) {
//			throw new UserNotFoundException("User Not Found Exception..");
//		}
//		
//		post.setUser(user.get());
//		post.setId(null);
//		
//		user.get().getPosts().add(post);
//		
////		ser.saveAllAndFlush(user.get());
//		ser.save(user.get());
//		
//	}
	
	@PostMapping("/users/{id}/posts")
	public ResponseEntity<Object> getPosts(@PathVariable Integer id, @RequestBody Post post) {
		Optional<User> user = ser.findById(id);
		
		if (user.isEmpty()) {
			throw new UserNotFoundException("Invalid user Id ");
			
		}
		
		post.setUser(user.get());
		Post savedPost = rep.save(post);
		
		URI uri = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(savedPost.getId())
					.toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping("/users/{id}/posts/{pid}")
	public Post getPost(@PathVariable Integer pid) {
		Optional<Post> p = rep.findById(pid);
		
		if (p.isEmpty()) {
			throw new UserNotFoundException("User Not Found");
		}
		
		return p.get();
		
	}
	
	
}
