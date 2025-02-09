package com.sergio.mockito.redsys.controller;

import org.springframework.stereotype.Component;

import com.sergio.mockito.redsys.service.ServicioUsuario;

@Component
public class ControladorUsuarioConstructor {
	
	private final ServicioUsuario servicioUsuario;

	public ControladorUsuarioConstructor(ServicioUsuario servicioUsuario) {
		super();
		this.servicioUsuario = servicioUsuario;
	}
	
	public void registrarUsuario(String usuario) {
		servicioUsuario.procesarUsuario(usuario);
	}

}
