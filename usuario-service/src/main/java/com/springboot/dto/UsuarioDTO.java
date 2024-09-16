package com.springboot.dto;


import com.springboot.entity.Persona;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuarioDTO {

	private String username;
	private String password;
	
	private Persona persona;
	
	
}