package com.lcwd.UserService.services;

import java.util.List;

import com.lcwd.UserService.entity.User;

public interface UserService {
	
	User saveUser(User user);
	
	List<User> getAllUsers();
	
	User getSingleUser(String userId);

}
