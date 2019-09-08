package com.source.controller;

import com.source.entity.User;
import com.source.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserHandler {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/findAll")
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @PostMapping("/findById/{id}")
    public User findUserById(@PathVariable("id") int id){
        return userRepository.findById(id);
    }

    @PostMapping("/saveUser")
    public void saveUser(@RequestBody User user){
        userRepository.save(user);
    }

    @PostMapping("/updateUser")
    public void update(@RequestBody User user){
        userRepository.update(user);
    }

    @DeleteMapping("/deleteUserById/{id}")
    public void delete(@PathVariable("id") int id){
        userRepository.deleteById(id);
    }
}
