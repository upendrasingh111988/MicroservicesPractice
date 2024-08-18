package com.lcwd.UserService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.lcwd.UserService.entity.User;
import com.lcwd.UserService.services.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/createUser")
	public ResponseEntity<User> createNewUser(@RequestBody User user){
		User userfromui = userService.saveUser(user);
		return new  ResponseEntity<User>(userfromui, HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllUser")
	public ResponseEntity<List<User>> getAllUsers(){
		
		List<User> allUsers = userService.getAllUsers();
		return new ResponseEntity<List<User>>(allUsers,HttpStatus.OK);
	}
	@GetMapping("/{userId}")
	public ResponseEntity<User> getsingleUser(@PathVariable String userId){
		
		User singleUser = userService.getSingleUser(userId);
		
		return new ResponseEntity<User>(singleUser,HttpStatus.OK);
	}
	
	@PutMapping("update/{userId}")
	public ResponseEntity<User> updateUser(@RequestBody User user , @PathVariable String userId){
		User updatedUser = userService.updateUser(user, userId);
		
		return  new ResponseEntity<User>(updatedUser,HttpStatus.OK);
		
	}

}
