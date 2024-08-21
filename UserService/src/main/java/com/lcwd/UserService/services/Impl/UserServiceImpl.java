package com.lcwd.UserService.services.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.apache.logging.log4j.Logger;
import org.slf4j.ILoggerFactory;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lcwd.UserService.UserRepo.UserRepo;
import com.lcwd.UserService.entity.User;
import com.lcwd.UserService.exception.ResourceNotFoundException;
import com.lcwd.UserService.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	private org.slf4j.Logger logger=LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public User saveUser(User user) {
		String radomuid = UUID.randomUUID().toString();
		user.setUserId(radomuid);
		User saveduser = userRepo.save(user);
		return saveduser;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> allusers = userRepo.findAll();
		return allusers;
	}

	@Override
	public User getSingleUser(String userId) {
		User singleUser = userRepo.findById(userId)
		.orElseThrow(()-> new ResourceNotFoundException("Resource Not found exception","userId","userId"));
		
		// fetch ratings of the above user from rating service
		//http://localhost:8085/ratings/users/8e9e58f6-2e88-4afa-a914-b1478184b30c
		ArrayList ratingsOfUsers = restTemplate.getForObject("http://localhost:8083/ratings/users/" + singleUser.getUserId(), ArrayList.class);
		
		logger.info("printing url object::"+ ratingsOfUsers);
		singleUser.setRatings(ratingsOfUsers);
		return singleUser;
	}

	@Override
	public User updateUser(User user, String userId) {
		
		User existinguser = userRepo.findById(userId)
		.orElseThrow(()-> new ResourceNotFoundException("not found resource","userid","userId"));
		existinguser.setName(user.getName());
		existinguser.setEmail(user.getEmail());
		existinguser.setAbout(user.getAbout());
		userRepo.save(existinguser);
		return existinguser;
	}

}
