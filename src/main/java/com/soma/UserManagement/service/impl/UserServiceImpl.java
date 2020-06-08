package com.soma.UserManagement.service.impl;

import com.soma.UserManagement.document.User;
import com.soma.UserManagement.respository.UserRepository;
import com.soma.UserManagement.service.UserServices;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserServices {

    private static Logger log = LogManager.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        log.info("Inside getAllUser method");
        return userRepository.findAll();
    }

    @Override
    public User getUser(Long userId) throws Exception {
        log.info("Inside the getUser method");
        Optional<User> tempUser = userRepository.findByUserId(userId);
        if (!tempUser.isPresent())
            throw new Exception("User doesn't exist");
        return tempUser.get();
    }

    @Override
    public User addUser(User user) throws Exception {
        log.info("Inside the addUser method");
        if (userRepository.findByUserId(user.getUserId()).isPresent())
            throw new Exception("User exist with same userId");
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long userId, User user) throws Exception {
        Optional<User> fetchedUser = userRepository.findByUserId(userId);
        if (!fetchedUser.isPresent())
            throw new Exception("User doesn't exist");
        User updatedUser = fetchedUser.get();
        updatedUser.setUserName(user.getUserName());
        updatedUser.setUserAddress(user.getUserAddress());
        return userRepository.save(updatedUser);
    }

    @Override
    public void deleteUser(Long userId) throws Exception {
        if (!userRepository.findByUserId(userId).isPresent())
            throw new Exception("User doesn't exists");
        userRepository.delete(userRepository.findByUserId(userId).get());
    }
}
