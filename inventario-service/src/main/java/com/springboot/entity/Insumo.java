package com.springboot.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "insumo")
public class Insumo {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int insumo_id;
	private String nombre;
	private String descripcion;
	private String unidad_medida;
	private Boolean activo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "marca_id")
	private Marca marca;

	public Insumo(String nombre, String descripcion, String unidad_medida, Boolean activo, Marca marca) {
		
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.unidad_medida = unidad_medida;
		this.activo = activo;
		this.marca = marca;
	}
	
	
	
}
