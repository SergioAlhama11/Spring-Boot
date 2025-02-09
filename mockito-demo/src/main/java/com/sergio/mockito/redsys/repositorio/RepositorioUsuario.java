package com.sergio.mockito.redsys.repositorio;

import org.springframework.stereotype.Repository;

@Repository
public class RepositorioUsuario {

	public void guardarUsuario(String usuario) {
		System.out.println("Usuario guardado en la base de datos: " + usuario);
	}
	
}
