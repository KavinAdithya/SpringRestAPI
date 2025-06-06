package com.techcrack.restfulWebService.socialmedia.data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Repository;

import com.techcrack.restfulWebService.socialmedia.entity.User;

@Repository
public class UserDaoManage {
	private static final List<User> users = new ArrayList<>();
	private static int userCount = 0;
	
	static {
		users.add(new User(++userCount, "James Clear", LocalDate.now().minusYears(18)));
		users.add(new User(++userCount, "James Gosling", LocalDate.now().minusYears(20)));
		users.add(new User(++userCount, "Robert T Kiyosaki", LocalDate.now().minusYears(40)));
	}
	
	public List<User> findAllUser() {
		return users;
	}
	
	public User saveUser(User user) {
		user.setId(++userCount);
		users.add(user);
		
		return user;
	}
	
	public User findOne(Integer id) {
		Predicate<User> predicate = user -> user.getId() == id;
		
		return users.stream()
					.filter(predicate)
					.toList()
					.getFirst();
	}
}
