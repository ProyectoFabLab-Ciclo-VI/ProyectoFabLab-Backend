package com.springboot.dto;

import java.util.Date;

import com.springboot.entity.Categoria;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor 
@Data
public class MaquinaDTO {

	private String nombre;
	private Date fecha_compra;
	private double precio;
	private String codigo_upeu;
	private String estado;
	private double porc_desperdicio;
	private String tipo_cotizacion;
	private Boolean activo;
	
	private Categoria categoria;
	
	
}
