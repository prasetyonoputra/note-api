package com.kurupuxx.notesapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kurupuxx.notesapi.entities.User;
import com.kurupuxx.notesapi.repositories.UserRepository;

@RestController
@RequestMapping(path = "/api/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllUser() {
        return (List<User>) userRepository.findAll();
    }
}
