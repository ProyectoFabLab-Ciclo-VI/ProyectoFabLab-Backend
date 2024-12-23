package com.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


import com.springboot.entity.Usuario;
import com.springboot.repository.UsuarioRepository;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	//Esta injección para el service de email
	@Autowired
	private JavaMailSender mailSender;
	
	//Esto es para listar pero por paginación
	public Page<Usuario> getAllUsuarios(int page, int size){
		Pageable pageable = PageRequest.of(page, size);
		return usuarioRepository.findAll(pageable);
	}
	/*
	 * Esto es solo para listar
	public List<Usuario> list(){
		return usuarioRepository.findAll();
	}*/
	
	public Optional<Usuario> getOne(int id){
		return usuarioRepository.findById(id);
	}
	
	public void save(Usuario usuario) {
		usuarioRepository.save(usuario);
	}
	
	public void delete(int id) {
		usuarioRepository.deleteById(id);
	}
	
	public boolean validarUsuario(String username, String password) {
		//Aca buscamos al usuario por su username dentro de nuestra base de datos
		Usuario usuario = usuarioRepository.findByUsername(username);
		
		//Y aca validamos si el usuario existe y la contraseña coincide
		return usuario != null && usuario.getPassword().equals(password);
	}
	
	//Este método sirve para enviar un email de confirmación a los nuevos usuarios (texto)
	public void sendEmail(String to, String subject, String text) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		mailSender.send(message);		
	}
	
	//Este método sirve para enviar un email de confirmación a los nuevos usuarios (html)
	public void sendHtmlEmail(String to, String subject, String body) throws MailException, MessagingException {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true); //true para indicar que es multipart
		helper.setTo(to);
		helper.setSubject(subject);
		helper.setText(body, true); //true para indicar que el contenido es HTML
		mailSender.send(message);
	}
	
	//Este método sirve para buscar el email de una persona
	 public Usuario findByEmail(String email) {
	        return usuarioRepository.findByPersonaEmail(email);
	    }
	
}
