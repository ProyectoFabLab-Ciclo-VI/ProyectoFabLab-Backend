package com.springboot.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.entity.Configuracion_Cargo;

public interface Configuracion_CargoRepository extends JpaRepository<Configuracion_Cargo, Integer>{

	Page<Configuracion_Cargo> findAll (Pageable pageable);
}
