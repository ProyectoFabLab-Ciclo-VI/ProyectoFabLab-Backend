package com.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springboot.entity.Modelo_Predefinido;
import com.springboot.repository.Modelo_predefinidoRepository;

@Service
public class Modelo_predefinidoService {

	@Autowired
	private Modelo_predefinidoRepository modelo_predefinidoRepository;
	
	public Page<Modelo_Predefinido> getAllModelos (int page, int size){
		Pageable pageable = PageRequest.of(page, size);
		return modelo_predefinidoRepository.findAll(pageable);
	}
	
	//Para listar sin paginacion
	public List<Modelo_Predefinido> list(){
		return modelo_predefinidoRepository.findAll();
	}
	
	public Optional<Modelo_Predefinido> getOne (int id){
		return modelo_predefinidoRepository.findById(id);
	}
	
	public void save (Modelo_Predefinido modelo_Predefinido) {
		modelo_predefinidoRepository.save(modelo_Predefinido);
	}
	
	public void delete (int id) {
		modelo_predefinidoRepository.deleteById(id);
	}
	
	//Para filtrar por estado ya sea "nuevo" o "viejo"
	public List<Modelo_Predefinido> obtenerPorEstado (String estado){
		return modelo_predefinidoRepository.findByEstado(estado);
	}
}
