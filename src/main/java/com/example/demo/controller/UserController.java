package com.example.demo.controller;

import static com.example.demo.common.ConstantAttributes.ADD_USER;
import static com.example.demo.common.ConstantAttributes.DELETE_ALL_USERS;
import static com.example.demo.common.ConstantAttributes.DELETE_BY_ID;
import static com.example.demo.common.ConstantAttributes.GET_ALL_USERS;
import static com.example.demo.common.ConstantAttributes.GET_USER_BY_ID;
import static com.example.demo.common.ConstantAttributes.UPDATE_USER;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
	private final UserService userService;

	@GetMapping(GET_ALL_USERS)
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping(GET_USER_BY_ID)
	public User findUserById(@PathVariable String id) {
		return userService.findUserById(id);
	}

	@PostMapping(ADD_USER)
	public String addUser(@RequestBody User user) {
		return userService.addUser(user);
	}

	@PutMapping(UPDATE_USER)
	public String updateUser(@RequestBody User user) {
		//UPDATE USER
		return userService.addUser(user);
	}

	@DeleteMapping(DELETE_ALL_USERS)
	public String deleteAll() {
		return userService.deleteAllUsers();
	}

	@DeleteMapping(DELETE_BY_ID)
	public String deleteById(@PathVariable String id) {
		return userService.deleteById(id);
	}
}
