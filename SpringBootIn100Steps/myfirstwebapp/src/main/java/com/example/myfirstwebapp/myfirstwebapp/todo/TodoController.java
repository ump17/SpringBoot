package com.example.myfirstwebapp.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.myfirstwebapp.myfirstwebapp.login.LoginController;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoController {
	
	@Autowired
	private TodoServices todoServices;
	
	@Autowired
	private LoginController loginController;

	@RequestMapping("/list-todos")
	public String listAllTodos(ModelMap model) {
		 List<Todo> todos =	todoServices.findByUsername(loginController.getLoggedinUsername());
		 model.put("todos", todos);
		return "listTodos";
	}
	
	@GetMapping("/add-todo")
	public String addTodos(ModelMap model) {
		String username = getLoggedinUsername(model);
		Todo todo = new Todo(0,username,"",LocalDate.now().plusYears(1),false);
		model.put("todo", todo);
		return "todo";
	}
	
//	@PostMapping("/add-todo")
//	public String showAllTodos(@RequestParam String description, ModelMap model) {		
//		String username = (String)model.get("name");
//		todoServices.addTodo(username, description, LocalDate.now().plusYears(1), false);
//		return "redirect:list-todos";
//	}
	//Above controller has issue that to get more field like "done" we have to create more requestparam.
	
	@PostMapping("/add-todo")
	public String showAllTodos(ModelMap model, @Valid Todo todo, BindingResult result ) {	
		
		if(result.hasErrors()) {
			return "todo";
		}
			
		String username = getLoggedinUsername(model);
		todoServices.addTodo(username, todo.getDescription(), LocalDate.now().plusYears(1), false);
		return "redirect:list-todos";
	}

	private String getLoggedinUsername(ModelMap model) {
		return loginController.getLoggedinUsername();
	}
	
	@RequestMapping("/delete-todo")
	public String deleteTodo(@RequestParam int id) {
		 // delete, redirect
		todoServices.deleteById(id);
		return "redirect:list-todos";
				
	}
	
	@GetMapping("/update-todo")
	public String showUpdateTodoPage(ModelMap model, @RequestParam int id) {	
		Todo todo = todoServices.findById(id);
		model.put("todo", todo);
		return "todo";
				
	}
	
	@PostMapping("/update-todo")
	public String updateTodoPage(ModelMap model, @Valid Todo todo,BindingResult result) {	
		
		
		if(result.hasErrors()) {
			return "todo";
		}
		else {
			String username = getLoggedinUsername(model);
			todo.setUsername(username);
			todoServices.updateTodo(todo);
			return "redirect:list-todos";
		}
		
				
	}
	
}
