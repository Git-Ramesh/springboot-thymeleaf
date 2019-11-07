package com.rs.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.rs.app.exception.UserAlreadyExists;
import com.rs.app.exception.UserNotFoundException;
import com.rs.app.model.User;

@Service
public class UserServiceImpl implements UserService {
	public static List<User> users = new ArrayList<>();

	static {
		User user1 = new User("Ramesh", "ramesh@test.com", 24, "Hyderabad");
		user1.setId(1L);
		user1.getLanguages().add("English");
		user1.getLanguages().add("Telugu");

		User user2 = new User("Jag", "jag@test.com", 35, "Chenni");
		user2.setId(2L);
		user2.getLanguages().add("English");
		user2.getLanguages().add("Tamil");

		users.add(user1);
		users.add(user2);
	}

	@Override
	public User addUser(User user) {
		if (users.stream().anyMatch(u -> u.getId() == user.getId())
				|| users.stream().anyMatch(u -> u.getEmail().equals(user.getEmail()))) {
			throw new UserAlreadyExists("User aleady exisits");
		}
		users.add(user);
		return user;
	}

	@Override
	public User getUser(Long id) {
		return users.stream().filter(user -> user.getId() == id).findFirst().orElseThrow(() -> new UserNotFoundException("User not found"));
	}

	@Override
	public List<User> getAllUsers() {
		return users;
	}

	@Override
	public void removeUser(Long id) {
		User user = getUser(id);
		users.remove(user);
	}

	@Override
	public void removeUser(User user) {
		users.remove(user);
	}

	@Override
	public User updateUser(User modifiedUser) {
		User user = getUser(modifiedUser.getId());
		BeanUtils.copyProperties(modifiedUser, user);
		return getUser(modifiedUser.getId());
	}

}
