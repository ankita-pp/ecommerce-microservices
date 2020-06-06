package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.example.demo.common.ConstantAttributes.*;

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
    @Validated
    public String addUser(@RequestBody @Valid User user) {
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
