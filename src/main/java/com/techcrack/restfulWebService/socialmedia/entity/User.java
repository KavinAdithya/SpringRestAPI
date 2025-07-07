package com.techcrack.restfulWebService.socialmedia.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="customer")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Size(min = 2, message = "Name of the User must be greater than 2")
	private String name;
	
	@Past(message = "Birth Date of the User must in past")
	private LocalDate dob;
	
	
	@OneToMany(mappedBy="user", fetch = FetchType.EAGER, cascade= CascadeType.ALL)
	private List<Post> posts;
	
	public User() {
		super();
	}

	public User(Integer id, String name, LocalDate dob, List<Post> posts) {
		super();
		this.id = id;
		this.name = name;
		this.posts = posts;
		this.dob = dob;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", dob=" + dob + ", posts=" + posts + "]";
	}
}
