package de.twist.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.twist.todo.model.ToDoModel;

public interface ToDoRepository extends JpaRepository<ToDoModel, Long> {

}
