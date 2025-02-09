package com.sergio.mockito.redsys.calculadoraAvanzada;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

public class CalculadoraAvanzadaControllerTest {
	
	@Test
	public void testRealizarOperaciones() {
		ServicioRegistro servicioRegistroMock = mock(ServicioRegistro.class);
		ValidadorOperaciones validadorOperacionesMock = mock(ValidadorOperaciones.class);
		
		when(validadorOperacionesMock.validar(10, 5)).thenReturn(true);
		
		CalculadoraAvanzada calculadoraAvanzada = new CalculadoraAvanzada(servicioRegistroMock, validadorOperacionesMock);
		
		CalculadoraAvanzadaController calculadoraAvanzadaController = new CalculadoraAvanzadaController(calculadoraAvanzada);
		
		calculadoraAvanzadaController.realizarOperaciones();
		
		verify(servicioRegistroMock).registrarOperacion("Suma", 10, 5);
		verify(servicioRegistroMock).registrarOperacion("Resta", 10, 5);
		verify(servicioRegistroMock, times(2)).registrarOperacion(anyString(), eq(10), eq(5));
	
		verify(validadorOperacionesMock, times(2)).validar(10, 5);
	}
	
	@Test
	public void testSuma() {
		
		ServicioRegistro servicioRegistroMock = mock(ServicioRegistro.class);
		ValidadorOperaciones validadorOperacionesMock = mock(ValidadorOperaciones.class);
		
		CalculadoraAvanzada calculadoraAvanzada = new CalculadoraAvanzada(servicioRegistroMock, validadorOperacionesMock);
		CalculadoraAvanzadaController controller = new CalculadoraAvanzadaController(calculadoraAvanzada);
		
		when(validadorOperacionesMock.validar(10, 5)).thenReturn(true);

		int resultado = controller.suma();
		
		assertEquals(15, resultado);
		
	}
	
	@Test
	public void testResta() {
		
		ServicioRegistro servicioRegistroMock = mock(ServicioRegistro.class);
		ValidadorOperaciones validadorOperacionesMock = mock(ValidadorOperaciones.class);
		
		CalculadoraAvanzada calculadoraAvanzada = new CalculadoraAvanzada(servicioRegistroMock, validadorOperacionesMock);
		
		CalculadoraAvanzadaController controller = new CalculadoraAvanzadaController(calculadoraAvanzada);
		
		when(validadorOperacionesMock.validar(10, 5)).thenReturn(true);
		when(validadorOperacionesMock.isAGraterThanB(10, 5)).thenReturn(true);
		
		int resultado = controller.resta();
		
		assertEquals(5, resultado);
		
		verify(validadorOperacionesMock, times(1)).validar(10, 5);
		
		verify(servicioRegistroMock).registrarOperacion("Resta", 10, 5);
		verify(servicioRegistroMock).registrarOperacion(anyString(), eq(10), eq(5));
		
	}

}
