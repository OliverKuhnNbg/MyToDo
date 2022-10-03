package de.twist.todo;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import de.twist.todo.model.User;
import de.twist.todo.service.UserService;

@SpringBootApplication
public class ToDoApplication {
	
	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(ToDoApplication.class, args);
	}

	@Bean
    CommandLineRunner init(UserService userService) {
        return args -> {
            Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
                User user = new User();
                user.setEmail(name.toLowerCase() + "@domain.com");
                user.setName(name);
                userService.saveUser(user);
            });
            userService.findAll().forEach(System.out::println);
            
        };
    }

}
