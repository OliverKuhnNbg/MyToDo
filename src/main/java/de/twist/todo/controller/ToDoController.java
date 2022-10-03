package de.twist.todo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.twist.todo.model.ToDoModel;
import de.twist.todo.repository.ToDoRepository;

@RestController
@RequestMapping("/api")
public class ToDoController {
	
	@Autowired
	private ToDoRepository toDoRepository;

	public ToDoController(ToDoRepository toDoRepository) {
	}
	
	@GetMapping(value="/todos")
	public List<ToDoModel> getToDos() {
		return convertIterableToList((List<ToDoModel>) toDoRepository.findAll());
	}
	
	@GetMapping(value = "/todo/{id}")
    public Optional<ToDoModel> getToDoById(@PathVariable long id) {
        return toDoRepository.findById(id);
    }
	
	@PostMapping(value = "/save-todo")
    public ToDoModel saveTodo(@RequestBody ToDoModel todo) {
        return toDoRepository.save(todo);
    }
	
	@PutMapping(value = "/todo/{id}")
    public ToDoModel putTodo(@PathVariable long id, @RequestBody ToDoModel todo) {
	    todo.setId(id);
	    return toDoRepository.save(todo);
	}
	
	
	private <E> List<E> convertIterableToList(Iterable<E> iter) {
	    List<E> list = new ArrayList<E>();
	    for (E item : iter) {
	        list.add(item);
	    }
	    return list;
	}
}
