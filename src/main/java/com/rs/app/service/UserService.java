package com.rs.app.service;

import java.util.List;

import com.rs.app.model.User;

public interface UserService {
	User addUser(User user);

	User getUser(Long id);

	List<User> getAllUsers();

	void removeUser(Long id);

	void removeUser(User user);

	User updateUser(User modifiedUser);
}
