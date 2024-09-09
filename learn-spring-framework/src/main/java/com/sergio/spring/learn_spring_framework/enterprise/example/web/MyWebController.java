package com.sergio.spring.learn_spring_framework.enterprise.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sergio.spring.learn_spring_framework.enterprise.example.business.BusinessService;

@Component
public class MyWebController {
	
	@Autowired
	private BusinessService businessService;
	
	public MyWebController(BusinessService businessService) {
		super();
		System.out.println("MyWebController - Constructor-based Inyection");
		this.businessService = businessService;
	}

	public long returnValueFromBusinessService() {
		return businessService.calculateSum();
	}
}

