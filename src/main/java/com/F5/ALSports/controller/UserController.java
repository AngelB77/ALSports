package com.F5.ALSports.controller;


import com.F5.ALSports.model.User;
import com.F5.ALSports.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {

        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAll();
    }

    @PostMapping("/users")
    public void  createUsers(@Valid @RequestBody User newUser) {
        userService.addUser(newUser);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable int id) {
        userService.deleteUser(id);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> findUserById(@PathVariable int id) {
        Optional<User> foundUser = userService.findUser(id);

        if(foundUser.isPresent()) {
            return new ResponseEntity<>(foundUser.get(), HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User updatedUser) {
        try {

            User user = userService.updatedUser(id, updatedUser);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {

            throw new RuntimeException("User not found with id: " + id);
        }
    }
}


