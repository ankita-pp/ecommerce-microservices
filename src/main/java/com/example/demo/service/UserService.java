package com.example.demo.service;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
	private final UserRepository userRepository;

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User findUserById(String id) {
		return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
	}

	public String addUser(User user) {
		try {
			userRepository.save(user);
			return "USER ADDED!";
		} catch (Exception ex) {
			log.error("Error occurred while saving user", ex);
			return "Error occurred while saving user:[" + ex.getMessage() + "]";
		}
	}

	public String deleteAllUsers() {
		try {
			userRepository.deleteAll();
			return "ALL USERS DELETED SUCCESSFULLY!";
		} catch (Exception ex) {
			log.error("Error occurred while deleting all users", ex);
			return "Error occurred while deleting user:[" + ex.getMessage() + "]";
		}
	}

	public String deleteById(String id) {
		try {
			userRepository.deleteUserById(id);
			return "USER with id [" + id + "] DELETED SUCCESSFULLY!";
		} catch (Exception ex) {
			log.error("Error occurred while deleting the user", ex);
			return "Error occurred while deleting the user:[" + ex.getMessage() + "]";
		}
	}
}
