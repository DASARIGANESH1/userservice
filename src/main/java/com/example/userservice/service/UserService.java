package com.example.userservice.service;

import com.example.userservice.model.User;
import com.example.userservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    // Create user
    public User createUser(User user){
        return userRepository.save(user);
    }

    // Get all users
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    // Get user by id
    public User getUserById(Long id){
        return userRepository.findById(id).orElse(null);
    }

    // Update user
    public User updateUser(Long id, User userDetails){
        User user = userRepository.findById(id).orElse(null);

        if(user != null){
            user.setName(userDetails.getName());
            user.setEmail(userDetails.getEmail());
            return userRepository.save(user);
        }

        return null;
    }

    // Delete user
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}