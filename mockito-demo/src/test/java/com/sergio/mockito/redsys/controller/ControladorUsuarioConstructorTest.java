package com.sergio.mockito.redsys.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

import com.sergio.mockito.redsys.service.ServicioUsuario;

public class ControladorUsuarioConstructorTest {
	
	@Test
	public void testRegistrarUsuario() {
		ServicioUsuario servicioUsuarioMock = mock(ServicioUsuario.class);
		
		ControladorUsuarioConstructor controladorUsuarioConstructor = new ControladorUsuarioConstructor(servicioUsuarioMock);
	
		String usuario= "Juan";
		
		controladorUsuarioConstructor.registrarUsuario(usuario);
		
		verify(servicioUsuarioMock).procesarUsuario("Juan");
	}

}
