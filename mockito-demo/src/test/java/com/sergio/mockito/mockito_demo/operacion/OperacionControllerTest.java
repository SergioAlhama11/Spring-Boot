package com.sergio.mockito.mockito_demo.operacion;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OperacionControllerTest {
	
	@Mock
	private Suma sumaMock;
	
	@Mock
	private Resta restaMock;
	
	@Mock
	private Multiplicacion multiplicacionMock;
	
	@InjectMocks
	private OperacionController operacionController;

	@Test
	void testOperacion() {
		
		when(sumaMock.sumar(6, 1)).thenReturn(7);
		when(restaMock.restar(1, 6)).thenReturn(-5);
		when(multiplicacionMock.multiplicar(3, 3)).thenReturn(9);
		
		assertEquals(7, operacionController.operacion(6, 1));
		assertEquals(-5, operacionController.operacion(1, 6));
		assertEquals(9, operacionController.operacion(3, 3));
	}
	
	@Test
	void testNumero1EsMayor() {
		
		when(sumaMock.sumar(3, 1)).thenReturn(4);
		assertEquals(4, operacionController.operacion(3, 1));
		
	}
	
	@Test
	void testNumero1EsMenor() {
		
		when(restaMock.restar(1, 3)).thenReturn(-2);
		assertEquals(-2, operacionController.operacion(1, 3));
		
	}
	
	@Test
	void testNumero1EsIgua() {
		
		when(multiplicacionMock.multiplicar(1, 1)).thenReturn(1);
		assertEquals(1, operacionController.operacion(1, 1));
		
	}

}
