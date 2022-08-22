package com.example.demojpa.service;

import com.example.demojpa.dao.UserRepository;
import com.example.demojpa.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<Users> getUsers() {
        return userRepository.findAll();
    }

    public Optional<Users> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    public List<Users> getUserByName(String name) {
        return userRepository.findUserByName(name);
    }

    public Users createUser(Users user) {
        return userRepository.save(user);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    public Users updateUser(Integer id, Users userDetails) {
        Users user = userRepository.findById(id).get();
        user.setName(userDetails.getName());
        user.setAddress(userDetails.getAddress());

        return userRepository.save(user);
    }
}
