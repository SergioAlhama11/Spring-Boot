package com.sergio.springboot.todo_web_app.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {
	
	//"say-hello" => "Hello! What are you learning today?"
	
	@RequestMapping("/say-hello")
	@ResponseBody
	public String sayHello() {
		return "<h1>Hello! What are you learning today?</h1>";
	}

}
