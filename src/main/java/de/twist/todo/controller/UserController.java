package de.twist.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.twist.todo.model.User;
import de.twist.todo.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getUsers() {
    	System.out.println();
        return (List<User>) userRepository.findAll();
    }

    @PostMapping("/save-users")
    void addUser(@RequestBody User user) {
        userRepository.save(user);
    }
    
}
