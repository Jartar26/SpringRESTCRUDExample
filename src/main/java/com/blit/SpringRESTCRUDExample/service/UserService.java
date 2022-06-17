package com.blit.SpringRESTCRUDExample.service;

import java.util.List;

import com.blit.SpringRESTCRUDExample.entity.User;

public interface UserService {
	
	User addUser(User user);
	
	List<User> getAllUsers();
	
	void updateUser(User user);
	
	User getUserById(int userId);
	
	void deleteUserById(int userId);

}
