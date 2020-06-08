package com.soma.UserManagement.controller;

import com.soma.UserManagement.document.User;
import com.soma.UserManagement.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/project/user")
public class UserController {

    @Autowired
    private UserServices userServices;

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userServices.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserFromUserId(@PathVariable("userId") String userId) throws Exception {
        Long id = Long.parseLong(userId);
        return new ResponseEntity<>(userServices.getUser(id), HttpStatus.OK);
    }

    @PostMapping("/signUp")
    public ResponseEntity<User> addUser(@RequestBody User user) throws Exception {
        User addedUser = userServices.addUser(user);
        return new ResponseEntity<>(addedUser, HttpStatus.CREATED);
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable String userId, @RequestBody User user) throws Exception {
        User updatedUser = userServices.updateUser(Long.parseLong(userId), user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<?> deleteUserById(@PathVariable String userId) throws Exception {
        userServices.deleteUser(Long.parseLong(userId));
        return new ResponseEntity<>("User with " + userId + " is deleted.", HttpStatus.OK);
    }

}
