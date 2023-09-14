package com.example.myfirstwebapp.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import jakarta.validation.Valid;

@Component
public class TodoServices {
	
	private static List<Todo> todos = new ArrayList();
	private static int todoCount =0;

	static {
		todos.add(new Todo(++todoCount,"ashish","learn aws",LocalDate.now().plusYears(1),false));
		todos.add(new Todo(++todoCount,"krishna","learn hibernate",LocalDate.now().plusYears(1),false));
	}
	
	public List<Todo> findByUsername(String username){
		Predicate<? super Todo> predicate = todo-> todo.getUsername().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList();
	}
	
	public Todo findById(int id){
		Predicate<? super Todo> predicate = todo-> todo.getId()==id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();	
		return todo;
		}
	
	public void deleteById(int id) {
		//todo-> todo.getId()==id
		
		Predicate<? super Todo> predicate = todo-> todo.getId()==id;
		todos.removeIf(predicate);
	}
	
	public void addTodo(String username, String description,LocalDate targetDate, boolean done) {
		Todo todo = new Todo(++todoCount,username,description,targetDate,done);
		todos.add(todo);
	}

	public void updateTodo(@Valid Todo todo) {
		deleteById(todo.getId());
		todos.add(todo);
		
	}

}
