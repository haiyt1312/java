package com.example.demojpa.controller;

import com.example.demojpa.exception.UserNotFoundException;
import com.example.demojpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demojpa.model.Users;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/demoApi")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value="/users", method=RequestMethod.GET)
    public List<Users> getUsers() {
        return userService.getUsers();
    }

    @RequestMapping(value="/findUserById/{id}", method=RequestMethod.GET)
    public Optional<Users> getUserById(@PathVariable(value = "id") Integer id) {
        return userService.getUserById(id);
    }

    @RequestMapping(value="/findUserByName", method=RequestMethod.GET)
    public List<Users> getUserByName(@RequestParam(required = true, name = "name") String name){
        return userService.getUserByName(name);
    }


    @RequestMapping(value="/createUser", method=RequestMethod.POST)
    public Users createUser(@RequestBody Users user) {
        return userService.createUser(user);
    }

    @RequestMapping(value="/updateUser/{id}", method=RequestMethod.PUT)
    public Users updateUser(@PathVariable(value = "id") Integer id, @RequestBody Users userDetail) {
        return userService.updateUser(id, userDetail);
    }

    @RequestMapping(value="/deleteUser/{id}", method=RequestMethod.DELETE)
    public void deleteUser(@PathVariable(value = "id") Integer id) {
        userService.deleteUser(id);
    }
}
