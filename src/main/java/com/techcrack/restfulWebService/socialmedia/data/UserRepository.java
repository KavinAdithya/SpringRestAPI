package com.techcrack.restfulWebService.socialmedia.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techcrack.restfulWebService.socialmedia.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
