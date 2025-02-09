package com.sergio.mockito.redsys.service;

import org.springframework.stereotype.Service;

@Service
public class CalculadoraService {
	
	public int suma(int num1, int num2) {
		return num1 + num2;
	}
	
	public int resta(int num1, int num2) {
		return num1 - num2;
	}
	
	public int multiplicacion(int num1, int num2) {
		return num1 * num2;
	}

}
