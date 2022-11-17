package de.twist.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.twist.todo.model.User;
import de.twist.todo.repository.UserRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/")
public class UserController {

	@Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }
    
    @GetMapping("/first-user")
    public User getFirstUser() {
        return userRepository.findAll().get(0);
    }

    @PostMapping("/save-user")
    void addUser(@RequestBody User user) {
        userRepository.save(user);
    }
}
