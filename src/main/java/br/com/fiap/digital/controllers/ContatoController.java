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
import br.com.fiap.digital.models.Contato;
import br.com.fiap.digital.repository.ContatoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("digital/contato")
public class ContatoController {
	Logger log = LoggerFactory.getLogger(ContatoController.class);

	@Autowired
	ContatoRepository repository;

	@GetMapping
	public List<Contato> index() {
		return repository.findAll();
	}

	@PostMapping
	public ResponseEntity<Contato> create(@RequestBody @Valid Contato contato) {
		log.info("Cadastrando contato " + contato);

		repository.save(contato);

		return ResponseEntity.status(HttpStatus.CREATED).body(contato);
	}

	@GetMapping("{id}")
	public ResponseEntity<Contato> show(@PathVariable Long id) {
		log.info("detalhando contato " + id);

		var contato = getContato(id);

		return ResponseEntity.ok(contato);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Contato> destroy(@PathVariable Long id) {
		log.info("apagando contato " + id);

		var contato = getContato(id);

		repository.delete(contato);

		return ResponseEntity.noContent().build();
	}

	@PutMapping("{id}")
	public ResponseEntity<Contato> update(@PathVariable Long id, @Valid @RequestBody Contato contato) {
		log.info("atualizando contato " + id);
		getContato(id);

		contato.setId(id);
		repository.save(contato);

		return ResponseEntity.ok(contato);
	}

	private Contato getContato(Long id) {
		return repository.findById(id).orElseThrow(() -> new RestNotFoundException("Contato nao encontrado"));
	}
}
