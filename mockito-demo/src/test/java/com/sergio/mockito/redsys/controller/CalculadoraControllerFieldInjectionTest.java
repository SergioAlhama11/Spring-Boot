package com.sergio.mockito.redsys.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.sergio.mockito.redsys.service.CalculadoraService;

public class CalculadoraControllerFieldInjectionTest {
	
	@Mock
	private CalculadoraService calculadoraService;
	
	@InjectMocks
	private CalculadoraControllerFieldInjection calculadoraControllerFieldInjection;
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void testSumar() {
		when(calculadoraService.suma(3, 2)).thenReturn(5);
		
		int resultado = calculadoraControllerFieldInjection.suma(3,2);		
		assertEquals(5, resultado);
		
	}
	
	@Test
	void testRestar() {
		when(calculadoraService.resta(2, 1)).thenReturn(1);
		
		int resultado = calculadoraControllerFieldInjection.resta(2,1);
		assertEquals(1, resultado);
	}
	
	@Test
	void testMultiplicar() {
		when(calculadoraService.multiplicacion(2, 2)).thenReturn(4);
		
		int resultado = calculadoraControllerFieldInjection.resta(2,2);
		assertEquals(4, resultado);
	}

}
