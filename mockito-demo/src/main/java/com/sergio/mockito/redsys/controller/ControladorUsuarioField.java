package com.sergio.mockito.redsys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sergio.mockito.redsys.service.ServicioUsuario;

@Component
public class ControladorUsuarioField {

	@Autowired
	private ServicioUsuario servicioUsuario;
	
	public void registrarUsuario(String usuario) {
		servicioUsuario.procesarUsuario(usuario);
	}
}
