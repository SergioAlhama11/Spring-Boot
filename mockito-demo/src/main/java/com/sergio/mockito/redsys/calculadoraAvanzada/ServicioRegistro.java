package com.sergio.mockito.redsys.calculadoraAvanzada;

import org.springframework.stereotype.Service;

@Service
public class ServicioRegistro {
	
	public void registrarOperacion(String operacion, int a, int b) {
		System.out.println("Registrando operacion: " + operacion + " con valores: " + a + " y " + b);
	}

}
