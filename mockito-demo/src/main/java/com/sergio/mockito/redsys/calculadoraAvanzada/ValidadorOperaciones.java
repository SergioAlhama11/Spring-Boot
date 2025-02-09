package com.sergio.mockito.redsys.calculadoraAvanzada;

import org.springframework.stereotype.Component;

@Component
public class ValidadorOperaciones {
	
	public boolean validar(int a, int b) {
		return a >= 0 && b >= 0;
	}
	
	public boolean isAGraterThanB(int a, int b) {
		return a > b;
	}
}
