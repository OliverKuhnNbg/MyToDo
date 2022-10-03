package de.twist.todo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ToDoModel {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	private String Title;
	private String Task;


	public Long getId() {
		return id;
	}
	public String getTitle() {
		return Title;
	}
	public String getTask() {
		return Task;
	}


	public void setId(Long id) {
		this.id = id;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public void setTask(String task) {
		Task = task;
	}
	
	

}
