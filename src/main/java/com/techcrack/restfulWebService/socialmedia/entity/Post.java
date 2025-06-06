package com.techcrack.restfulWebService.socialmedia.entity;

public class Post {
	private Integer id;
	private String decription;
	
	public Post() {
		super();
	}

	public Post(Integer id, String decription) {
		super();
		this.id = id;
		this.decription = decription;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDecription() {
		return decription;
	}

	public void setDecription(String decription) {
		this.decription = decription;
	}

	@Override
	public String toString() {
		return "Posts [id=" + id + ", decription=" + decription + "]";
	}
}
