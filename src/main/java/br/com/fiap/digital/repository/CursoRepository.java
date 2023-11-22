package br.com.fiap.digital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.digital.models.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
