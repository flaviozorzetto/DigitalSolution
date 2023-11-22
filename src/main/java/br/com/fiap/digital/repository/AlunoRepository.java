package br.com.fiap.digital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.digital.models.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
