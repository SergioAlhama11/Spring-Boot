package com.sergio.mockito.redsys.service;

import com.sergio.mockito.redsys.repositorio.RepositorioUsuario;

public class ServicioUsuario {
	
	private final RepositorioUsuario repositorioUsuario;

	public ServicioUsuario(RepositorioUsuario repositorioUsuario) {
		super();
		this.repositorioUsuario = repositorioUsuario;
	}
	
	public void procesarUsuario(String usuario) {
		System.out.println("Procesando usuario: " + usuario);
		repositorioUsuario.guardarUsuario(usuario);
	}

}
