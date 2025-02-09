package com.sergio.mockito.redsys.calculadoraAvanzada;

import org.springframework.stereotype.Component;

@Component
public class CalculadoraAvanzada {
	
	private final ServicioRegistro servicioRegistro;
	private final ValidadorOperaciones validadorOperaciones;
	
	
	public CalculadoraAvanzada(ServicioRegistro servicioRegistro, ValidadorOperaciones validadorOperaciones) {
		super();
		this.servicioRegistro = servicioRegistro;
		this.validadorOperaciones = validadorOperaciones;
	}
	
	public int sumar(int a, int b) {
		if (!validadorOperaciones.validar(a, b)) {
			throw new IllegalArgumentException("Valores no validos");
		}
		
		servicioRegistro.registrarOperacion("Suma", a, b);
		
		return a + b;
		
	}
	
	public int restar(int a, int b) {
		if (!validadorOperaciones.validar(a, b)) {
			throw new IllegalArgumentException("Valores no validos");
		} else if (!validadorOperaciones.isAGraterThanB(a, b)) {
			throw new IllegalArgumentException("A es menor que B");
		}
		
		servicioRegistro.registrarOperacion("Resta", a, b);
		
		return a - b;
		
	}
}
