package com.sergio.springboot.todo_web_app.todo;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class Utils {
	
	public boolean updateTask(Todo todo) {
		if (todo.getTargetDate().isBefore(LocalDate.now())) {
			return true;
		}
		return false;
	}

}
