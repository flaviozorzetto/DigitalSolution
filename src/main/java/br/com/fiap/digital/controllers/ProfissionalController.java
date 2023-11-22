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
import br.com.fiap.digital.models.Profissional;
import br.com.fiap.digital.repository.ProfissionalRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("digital/profissional")
public class ProfissionalController {
	Logger log = LoggerFactory.getLogger(ProfissionalController.class);

	@Autowired
	ProfissionalRepository repository;

	@GetMapping
	public List<Profissional> index() {
		return repository.findAll();
	}

	@PostMapping
	public ResponseEntity<Profissional> create(@RequestBody @Valid Profissional profissional) {
		log.info("Cadastrando profissional " + profissional);

		repository.save(profissional);

		return ResponseEntity.status(HttpStatus.CREATED).body(profissional);
	}

	@GetMapping("{id}")
	public ResponseEntity<Profissional> show(@PathVariable Long id) {
		log.info("Detalhando profissional " + id);

		var profissional = getProfissional(id);

		return ResponseEntity.ok(profissional);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Profissional> destroy(@PathVariable Long id) {
		log.info("Apagando profissional " + id);

		var profissional = getProfissional(id);

		repository.delete(profissional);

		return ResponseEntity.noContent().build();
	}

	@PutMapping("{id}")
	public ResponseEntity<Profissional> update(@PathVariable Long id, @Valid @RequestBody Profissional profissional) {
		log.info("Atualizando profissional " + id);
		getProfissional(id);

		profissional.setId(id);
		repository.save(profissional);

		return ResponseEntity.ok(profissional);
	}

	private Profissional getProfissional(Long id) {
		return repository.findById(id).orElseThrow(() -> new RestNotFoundException("Profissional nao encontrado"));
	}
}
