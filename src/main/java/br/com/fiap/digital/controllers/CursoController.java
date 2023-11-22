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
import br.com.fiap.digital.models.Curso;
import br.com.fiap.digital.repository.CursoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("vlearn/curso")
public class CursoController {
	Logger log = LoggerFactory.getLogger(CursoController.class);

	@Autowired
	CursoRepository repository;

	@GetMapping
	public List<Curso> index() {
		return repository.findAll();
	}

	@PostMapping
	public ResponseEntity<Curso> create(@RequestBody @Valid Curso curso) {
		log.info("Cadastrando curso " + curso);

		repository.save(curso);

		return ResponseEntity.status(HttpStatus.CREATED).body(curso);
	}

	@GetMapping("{id}")
	public ResponseEntity<Curso> show(@PathVariable Long id) {
		log.info("detalhando curso " + id);

		var curso = getCurso(id);

		return ResponseEntity.ok(curso);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Curso> destroy(@PathVariable Long id) {
		log.info("apagando curso " + id);

		var curso = getCurso(id);

		repository.delete(curso);

		return ResponseEntity.noContent().build();
	}

	@PutMapping("{id}")
	public ResponseEntity<Curso> update(@PathVariable Long id, @Valid @RequestBody Curso curso) {
		log.info("atualizando curso " + id);
		getCurso(id);

		curso.setId(id);
		repository.save(curso);

		return ResponseEntity.ok(curso);
	}

	private Curso getCurso(Long id) {
		return repository.findById(id).orElseThrow(() -> new RestNotFoundException("Curso nao encontrado"));
	}
}
