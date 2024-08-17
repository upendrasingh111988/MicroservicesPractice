package com.lcwd.UserService.UserRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lcwd.UserService.entity.User;

public interface UserRepo extends JpaRepository<User, String> {

}
