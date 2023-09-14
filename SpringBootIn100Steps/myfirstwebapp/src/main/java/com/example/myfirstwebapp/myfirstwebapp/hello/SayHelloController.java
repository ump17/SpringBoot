package com.example.myfirstwebapp.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SayHelloController {
	//http:localhost:8080/say-hello
	@RequestMapping("/say-hello")
	public String sayHello() {
		return "Hii, how are you???";
	}
	
	@RequestMapping("/say-hello-jsp")
	public String sayHelloJSP() {
		System.out.println("coming...............");
		return "sayHello";
	}

}
