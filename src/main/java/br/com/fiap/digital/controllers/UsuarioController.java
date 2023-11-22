package br.com.fiap.digital.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.digital.exceptions.RestNotFoundException;
import br.com.fiap.digital.models.Usuario;
import br.com.fiap.digital.repository.UsuarioRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("digital/usuario")
public class UsuarioController {
	Logger log = LoggerFactory.getLogger(UsuarioController.class);

	@Autowired
	UsuarioRepository repository;

	@GetMapping
	public List<Usuario> index() {
		return repository.findAll();
	}

	@PostMapping
	public ResponseEntity<Usuario> create(@RequestBody @Valid Usuario usuario) {
		log.info("Cadastrando usuario " + usuario);

		repository.save(usuario);

		return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
	}

	@GetMapping("{id}")
	public ResponseEntity<Usuario> show(@PathVariable Long id) {
		log.info("detalhando usuario " + id);

		var usuario = getUsuario(id);

		return ResponseEntity.ok(usuario);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Usuario> destroy(@PathVariable Long id) {
		log.info("apagando usuario " + id);

		var usuario = getUsuario(id);

		repository.delete(usuario);

		return ResponseEntity.noContent().build();
	}

	@PutMapping("{id}")
	public ResponseEntity<Usuario> update(@PathVariable Long id, @Valid @RequestBody Usuario usuario) {
		log.info("atualizando usuario " + id);
		getUsuario(id);

		usuario.setId(id);
		repository.save(usuario);

		return ResponseEntity.ok(usuario);
	}

	private Usuario getUsuario(Long id) {
		return repository.findById(id).orElseThrow(() -> new RestNotFoundException("Usuario nao encontrado"));
	}
}
