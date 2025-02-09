package com.sergio.mockito.redsys.controller;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.sergio.mockito.redsys.service.ServicioUsuario;

public class ControladorUsuarioFieldTest {
	
	@Mock
	private ServicioUsuario servicioUsuario;
	
	@InjectMocks
	private ControladorUsuarioField controladorUsuarioField;
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void testRegistarUsuario() {
		String usuario = "Juan";
		
		controladorUsuarioField.registrarUsuario(usuario);
				
		verify(servicioUsuario).procesarUsuario(usuario);
	}

}
