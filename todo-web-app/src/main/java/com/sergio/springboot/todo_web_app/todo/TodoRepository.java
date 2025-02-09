package com.sergio.springboot.todo_web_app.todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Integer>{
	
	public List<Todo> findByUsername(String username);
	
}
