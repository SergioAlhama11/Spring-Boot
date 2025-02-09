package com.sergio.mockito.redsys.controller;

import org.springframework.stereotype.Controller;

import com.sergio.mockito.redsys.service.CalculadoraService;

@Controller
public class CalculadoraControllerConstructorInjection {

	private final CalculadoraService calculadoraService;

	public CalculadoraControllerConstructorInjection(CalculadoraService calculadoraService) {
		super();
		this.calculadoraService = calculadoraService;
	}
	
	public int suma(int num1, int num2) {
		return calculadoraService.suma(num1, num2);
	}
	
	public int resta(int num1, int num2) {
		return calculadoraService.resta(num1, num2);
	}
	
	public int mult(int num1, int num2) {
		return calculadoraService.multiplicacion(num1, num2);
	}
	
	public int mult2(int num1, int num2) {
		return num1 * num2;
	}
	
}
