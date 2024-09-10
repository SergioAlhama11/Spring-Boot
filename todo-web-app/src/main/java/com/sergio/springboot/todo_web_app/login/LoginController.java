package com.sergio.springboot.todo_web_app.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	@RequestMapping("login")
	public String loginPage() {
		return "login";
	}

}
