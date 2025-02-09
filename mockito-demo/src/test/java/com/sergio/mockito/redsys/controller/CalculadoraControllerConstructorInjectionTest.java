package com.sergio.mockito.redsys.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sergio.mockito.redsys.service.CalculadoraService;

@ExtendWith(MockitoExtension.class)
public class CalculadoraControllerConstructorInjectionTest {
	
	@Mock
	private CalculadoraService calculadoraService;
	
	private CalculadoraControllerConstructorInjection calculadoraController;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		calculadoraController = new CalculadoraControllerConstructorInjection(calculadoraService);
	}
	
	@Test
	void testSuma() {
		when(calculadoraService.suma(3, 4)).thenReturn(7);
		
		int resultado = calculadoraController.suma(3, 4);
		assertEquals(7, resultado);
	}
	
	@Test
	void testResta() {
		when(calculadoraService.resta(5, 0)).thenReturn(5);
		
		int resultado = calculadoraController.resta(5, 0);
		assertEquals(5, resultado);
	}
	
	@Test
	void testMultiplicacion() {
		when(calculadoraService.multiplicacion(5, 1)).thenReturn(5);
		
		int resultado = calculadoraController.mult(5, 2);
		assertEquals(5, resultado);
	}
	
	@Test
	void testMultiplicacion2() {
		//when(calculadoraService.multiplicacion(5, 1)).thenReturn(5);
		
		int resultado = calculadoraController.mult2(5, 2);
		assertEquals(10, resultado);
	}
	
	

}
