package com.User.service;

import com.User.DTO.UserDTO;
import com.User.entity.User;

import java.util.List;

public interface User_service {
    User addUser(User user);
    User getUserById(Integer id);
    List<User> addAllUsers(List<User> users);
    List<User> getAllUsers();
    User updateUser(Integer id, User user);
    User updatePartialPart(Integer id, UserDTO userDTO);
}
