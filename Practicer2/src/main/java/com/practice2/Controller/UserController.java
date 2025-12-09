package com.practice2.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.practice2.Entity.User;
import com.practice2.exception.UserNotFoundException;



@RestController
public class UserController {

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable int id) {

        
        if (id == 1) {
            return new User(1, "Vishal", "vishal@gmail.com");
        }

        
        throw new UserNotFoundException("User Not Found with ID: " + id);
    }
}