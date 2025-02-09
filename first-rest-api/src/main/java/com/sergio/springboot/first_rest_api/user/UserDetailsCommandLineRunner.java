package com.sergio.springboot.first_rest_api.user;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsCommandLineRunner implements CommandLineRunner {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private UserDetailsRepository userDetailsRepository;

	public UserDetailsCommandLineRunner(UserDetailsRepository userDetailsRepository) {
		super();
		this.userDetailsRepository = userDetailsRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		
		userDetailsRepository.save(new UserDetails("Sergio", "User"));
		userDetailsRepository.save(new UserDetails("Sergio Alhama", "Admin"));
		userDetailsRepository.save(new UserDetails("Sergio Alhama Cosano", "Admin"));
		
		//List<UserDetails> users = userDetailsRepository.findAll();
		
		List<UserDetails> adminUsers = userDetailsRepository.findByRole("Admin");
		List<UserDetails> normalUsers = userDetailsRepository.findByRole("User");
		
		adminUsers.forEach(user -> logger.info(user.toString()));
		//normalUsers.forEach(user -> logger.info(user.toString()));
		
	}

}
