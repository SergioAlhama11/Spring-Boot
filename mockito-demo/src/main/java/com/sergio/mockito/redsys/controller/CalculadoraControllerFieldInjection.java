package com.sergio.mockito.redsys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sergio.mockito.redsys.service.CalculadoraService;

@Controller
public class CalculadoraControllerFieldInjection {
	
	@Autowired
	private CalculadoraService calculadoraService;
	
	public int suma(int num1, int num2) {
		return calculadoraService.suma(num1, num2);
	}
	
	public int resta(int num1, int num2) {
		return calculadoraService.resta(num1, num2);
	}
	
	public int mult(int num1, int num2) {
		return calculadoraService.multiplicacion(num1, num2);
	}
	
}
