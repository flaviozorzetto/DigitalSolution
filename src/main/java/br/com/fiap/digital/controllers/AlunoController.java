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
import br.com.fiap.digital.models.Aluno;
import br.com.fiap.digital.repository.AlunoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("vlearn/aluno")
public class AlunoController {
	Logger log = LoggerFactory.getLogger(AlunoController.class);

	@Autowired
	AlunoRepository repository;

	@GetMapping
	public List<Aluno> index() {
		return repository.findAll();
	}

	@PostMapping
	public ResponseEntity<Aluno> create(@RequestBody @Valid Aluno aluno) {
		log.info("Cadastrando aluno " + aluno);

		repository.save(aluno);

		return ResponseEntity.status(HttpStatus.CREATED).body(aluno);
	}

	@GetMapping("{id}")
	public ResponseEntity<Aluno> show(@PathVariable Long id) {
		log.info("detalhando aluno " + id);

		var aluno = getAluno(id);

		return ResponseEntity.ok(aluno);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Aluno> destroy(@PathVariable Long id) {
		log.info("apagando aluno " + id);

		var aluno = getAluno(id);

		repository.delete(aluno);

		return ResponseEntity.noContent().build();
	}

	@PutMapping("{id}")
	public ResponseEntity<Aluno> update(@PathVariable Long id, @Valid @RequestBody Aluno aluno) {
		log.info("atualizando aluno " + id);
		getAluno(id);

		aluno.setId(id);
		repository.save(aluno);

		return ResponseEntity.ok(aluno);
	}

	private Aluno getAluno(Long id) {
		return repository.findById(id).orElseThrow(() -> new RestNotFoundException("Aluno nao encontrado"));
	}
}
