package com.lcwd.UserService.services.Impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.UserService.UserRepo.UserRepo;
import com.lcwd.UserService.entity.User;
import com.lcwd.UserService.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public User saveUser(User user) {
		String radomuid = UUID.randomUUID().toString();
		//User userobj= new User();
		user.setUserId(radomuid);
		/*
		 * userobj.setName(user.getName()); userobj.setEmail(user.getEmail());
		 * userobj.setAbout(user.getAbout());
		 */
		User saveduser = userRepo.save(user);
		return saveduser;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getSingleUser(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
