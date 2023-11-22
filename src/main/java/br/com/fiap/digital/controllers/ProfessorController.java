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
import br.com.fiap.digital.models.Professor;
import br.com.fiap.digital.repository.ProfessorRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("vlearn/professor")
public class ProfessorController {
	Logger log = LoggerFactory.getLogger(ProfessorController.class);

	@Autowired
	ProfessorRepository repository;

	@GetMapping
	public List<Professor> index() {
		return repository.findAll();
	}

	@PostMapping
	public ResponseEntity<Professor> create(@RequestBody @Valid Professor professor) {
		log.info("Cadastrando professor " + professor);

		repository.save(professor);

		return ResponseEntity.status(HttpStatus.CREATED).body(professor);
	}

	@GetMapping("{id}")
	public ResponseEntity<Professor> show(@PathVariable Long id) {
		log.info("detalhando professor " + id);

		var professor = getProfessor(id);

		return ResponseEntity.ok(professor);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Professor> destroy(@PathVariable Long id) {
		log.info("apagando professor " + id);

		var professor = getProfessor(id);

		repository.delete(professor);

		return ResponseEntity.noContent().build();
	}

	@PutMapping("{id}")
	public ResponseEntity<Professor> update(@PathVariable Long id, @Valid @RequestBody Professor professor) {
		log.info("atualizando professor " + id);
		getProfessor(id);

		professor.setId(id);
		repository.save(professor);

		return ResponseEntity.ok(professor);
	}

	private Professor getProfessor(Long id) {
		return repository.findById(id).orElseThrow(() -> new RestNotFoundException("Professor nao encontrado"));
	}
}
