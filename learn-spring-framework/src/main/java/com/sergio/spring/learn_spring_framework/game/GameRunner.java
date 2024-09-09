package com.sergio.spring.learn_spring_framework.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {
	
	@Autowired
	private IGamingConsole gamingConsole;

	
	public GameRunner(IGamingConsole gamingConsole) {
		this.gamingConsole = gamingConsole;
	}

	public void run() {

		gamingConsole.up();
		gamingConsole.down();
		gamingConsole.left();
		gamingConsole.right();
		
	}

}
