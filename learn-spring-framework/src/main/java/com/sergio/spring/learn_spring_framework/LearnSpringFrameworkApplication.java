package com.sergio.spring.learn_spring_framework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.sergio.spring.learn_spring_framework.enterprise.example.web.MyWebController;
import com.sergio.spring.learn_spring_framework.game.GameRunner;

@SpringBootApplication
public class LearnSpringFrameworkApplication {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext context = 
				SpringApplication.run(LearnSpringFrameworkApplication.class, args);
		
		GameRunner runner = context.getBean(GameRunner.class);
		
		runner.run();
		
		MyWebController webController = context.getBean(MyWebController.class);
		
		System.out.println(webController.returnValueFromBusinessService());
		
	}

}
