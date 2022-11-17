package de.twist.todo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.twist.todo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	// additional Search Querys
	Optional<User> findByName(String name);
}
