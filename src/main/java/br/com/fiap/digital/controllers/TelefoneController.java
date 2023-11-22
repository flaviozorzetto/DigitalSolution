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
import br.com.fiap.digital.models.Telefone;
import br.com.fiap.digital.repository.TelefoneRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("vlearn/telefone")
public class TelefoneController {
	Logger log = LoggerFactory.getLogger(TelefoneController.class);

	@Autowired
	TelefoneRepository repository;

	@GetMapping
	public List<Telefone> index() {
		return repository.findAll();
	}

	@PostMapping
	public ResponseEntity<Telefone> create(@RequestBody @Valid Telefone telefone) {
		log.info("Cadastrando telefone " + telefone);

		repository.save(telefone);

		return ResponseEntity.status(HttpStatus.CREATED).body(telefone);
	}

	@GetMapping("{id}")
	public ResponseEntity<Telefone> show(@PathVariable Long id) {
		log.info("detalhando telefone " + id);

		var telefone = getTelefone(id);

		return ResponseEntity.ok(telefone);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Telefone> destroy(@PathVariable Long id) {
		log.info("apagando telefone " + id);

		var telefone = getTelefone(id);

		repository.delete(telefone);

		return ResponseEntity.noContent().build();
	}

	@PutMapping("{id}")
	public ResponseEntity<Telefone> update(@PathVariable Long id, @Valid @RequestBody Telefone telefone) {
		log.info("atualizando telefone " + id);
		getTelefone(id);

		telefone.setId(id);
		repository.save(telefone);

		return ResponseEntity.ok(telefone);
	}

	private Telefone getTelefone(Long id) {
		return repository.findById(id).orElseThrow(() -> new RestNotFoundException("Telefone nao encontrado"));
	}
}
