package com.springboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int usuario_id;
	private String username;
	private String password;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "persona_id")
	private Persona persona;

	public Usuario(String username, String password, Persona persona) {
		
		this.username = username;
		this.password = password;
		this.persona = persona;
	}
	
	
}
