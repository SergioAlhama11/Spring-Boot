package com.sergio.mockito.redsys.calculadoraAvanzada;

import org.springframework.stereotype.Component;

@Component
public class CalculadoraAvanzadaController {

	private final CalculadoraAvanzada calculadoraAvanzada;

	public CalculadoraAvanzadaController(CalculadoraAvanzada calculadoraAvanzada) {
		super();
		this.calculadoraAvanzada = calculadoraAvanzada;
	}
	
	public void realizarOperaciones() {
		
		int a = 10;
		int b = 5;
		
		System.out.println("Suma: " + calculadoraAvanzada.sumar(a, b));
		System.out.println("Resta: " + calculadoraAvanzada.restar(a, b));
	}
	
	public int suma() {
		int a = 10;
		int b = 5;
		
		return calculadoraAvanzada.sumar(a, b);
	}
	
	public int resta() {
		int a = 10;
		int b = 5;
		
		return calculadoraAvanzada.restar(a, b);
	}
}
