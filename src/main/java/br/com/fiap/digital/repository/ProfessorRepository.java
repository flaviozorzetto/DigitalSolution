package br.com.fiap.digital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.digital.models.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}