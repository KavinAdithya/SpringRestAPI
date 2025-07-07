package com.techcrack.restfulWebService.socialmedia.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techcrack.restfulWebService.socialmedia.entity.Post;

public interface PostRepository extends JpaRepository<Post, Integer>{

}
