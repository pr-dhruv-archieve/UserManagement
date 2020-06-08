package com.soma.UserManagement.service;

import com.soma.UserManagement.document.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserServices {
    List<User> getAllUsers();
    User getUser(Long id) throws Exception;
    User addUser(User user) throws Exception;
    User updateUser(Long userId, User user) throws Exception;
    void deleteUser(Long userId) throws Exception;
}
