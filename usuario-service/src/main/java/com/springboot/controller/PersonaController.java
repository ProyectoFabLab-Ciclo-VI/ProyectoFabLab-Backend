package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.dto.PersonaDTO;
import com.springboot.entity.Cargo;
import com.springboot.entity.Persona;
import com.springboot.repository.CargoRepository;
import com.springboot.service.PersonaService;

@RestController
@RequestMapping("/apipersona")
public class PersonaController {

	@Autowired
	private PersonaService personaService;
	
	@Autowired
	private CargoRepository cargoRepository;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Persona>> listarPersona() {
		List<Persona> listPersona = personaService.list();
		return new ResponseEntity<List<Persona>>(listPersona, HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> addPersona(@RequestBody PersonaDTO personaDTO){
		
		Cargo cargo = cargoRepository.findById(personaDTO.getCargo().getCargo_id()).orElseThrow(() -> new RuntimeException("Cargo no encontrado con id"));
		
		Persona persona = new Persona(personaDTO.getNombre(),
				                      personaDTO.getApellido(),
				                      personaDTO.getFecha_nacimiento(),
				                      personaDTO.getCodigo(),
				                      personaDTO.getEmail(),
				                      cargo);
		personaService.save(persona);
		return new ResponseEntity<>(persona, HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updatePersona(@PathVariable ("id") int id, @RequestBody PersonaDTO personaDTO){
		Persona persona = personaService.getOne(id).get();
		persona.setNombre(personaDTO.getNombre());
		persona.setApellido(personaDTO.getApellido());
		persona.setFecha_nacimiento(personaDTO.getFecha_nacimiento());
		persona.setCodigo(personaDTO.getCodigo());
		persona.setEmail(personaDTO.getEmail());
		personaService.save(persona);
		return new ResponseEntity("Persona actualizada", HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deletePersona (@PathVariable ("id") int id){
		personaService.delete(id);
		return new ResponseEntity("Persona eliminada", HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getPersonaById (@PathVariable ("id") int id){
		Persona persona = personaService.finPersonaById(id);
        return ResponseEntity.ok(persona);
	}
}
