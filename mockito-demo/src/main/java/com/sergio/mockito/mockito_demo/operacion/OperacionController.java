package com.sergio.mockito.mockito_demo.operacion;

public class OperacionController {
	
	private Suma suma;
	private Resta resta;
	private Multiplicacion multiplicacion;
	
	public int operacion(int numero1, int numero2) {
		int resultado = 0;
		if (numero1 > numero2) {
			resultado = suma.sumar(numero1, numero2);
		} else if (numero1 < numero2) {
			resultado = resta.restar(numero1, numero2);
		} else {
			resultado = multiplicacion.multiplicar(numero1, numero2);
		}
		
		return resultado;
	}
}
	
class Suma {
	public int sumar(int numero1, int numero2) {
		return numero1 + numero2;
	}
}
	
class Resta {
	public int restar(int numero1, int numero2) {
		return numero1 - numero2;
	}
}
	
class Multiplicacion {
	public int multiplicar(int numero1, int numero2) {
		return numero1 * numero2;
	}
}


