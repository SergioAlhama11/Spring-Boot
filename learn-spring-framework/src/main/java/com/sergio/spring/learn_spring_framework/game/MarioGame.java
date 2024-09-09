package com.sergio.spring.learn_spring_framework.game;

import org.springframework.stereotype.Component;

@Component
public class MarioGame implements IGamingConsole {
	
	public void up() {
		System.out.println("MarioGame -> Up");
	}
	
	public void down() {
		System.out.println("MarioGame -> Down");
	}
	
	public void left() {
		System.out.println("MarioGame -> Left");
	}
	
	public void right() {
		System.out.println("MarioGame -> Right");
	}

}
