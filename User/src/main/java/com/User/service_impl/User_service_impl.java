package com.User.service_impl;

import com.User.DTO.UserDTO;
import com.User.entity.User;
import com.User.repository.User_Repository;
import com.User.service.User_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class User_service_impl implements User_service {

    @Autowired
    private User_Repository user_repository;

    @Override
    public User addUser(User user){
        return user_repository.save(user);
    }

    @Override
    public User getUserById(Integer id){
        return user_repository.findById(id).get();
    }

    @Override
    public List<User> addAllUsers(List<User> Users){
        return user_repository.saveAll(Users);
    }

    @Override
    public List<User> getAllUsers() {
        return user_repository.findAll();
    }

    @Override
    public User updateUser(Integer id, User user){
        Optional<User> oldUser = user_repository.findById(id);

        if(oldUser.isPresent()){
            User Old = oldUser.get();
            Old.setFirstName(user.getFirstName());
            Old.setLastName(user.getLastName());
            Old.setEmail(user.getEmail());
            Old.setMobileNumber(user.getMobileNumber());

            return user_repository.save(Old);
        }
        else{
            return  user_repository.save(user);
        }
    }

    @Override
    public User updatePartialPart(Integer id, UserDTO userDTO) {
        Optional<User> optionalUser = user_repository.findById(id);
        if (optionalUser.isEmpty()) {
            return null;
        }

        User user = optionalUser.get();
        if (userDTO.getFirstName() != null) {
            user.setFirstName(userDTO.getFirstName());
        }
        if (userDTO.getLastName() != null) {
            user.setLastName(userDTO.getLastName());
        }
        if (userDTO.getEmail() != null) {
            user.setEmail(userDTO.getEmail());
        }
        if (userDTO.getMobileNumber() != null) {
            user.setMobileNumber(userDTO.getMobileNumber());
        }
        System.out.println(user);
        user_repository.save(user);
        return user;
    }
}


