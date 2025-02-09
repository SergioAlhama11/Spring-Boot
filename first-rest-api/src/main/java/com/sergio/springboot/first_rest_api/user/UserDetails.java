package com.sergio.springboot.first_rest_api.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class UserDetails {
	
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String role;
	
	public UserDetails() {
	}
	
	public UserDetails(String name, String role) {
		super();
		this.name = name;
		this.role = role;
	}

	public Long getIdLong() {
		return id;
	}

	public void setIdLong(Long idLong) {
		this.id = idLong;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserDetails [idLong=" + id + ", name=" + name + ", role=" + role + "]";
	}

}
