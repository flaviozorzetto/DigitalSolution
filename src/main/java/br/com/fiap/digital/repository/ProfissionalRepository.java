package br.com.fiap.digital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.digital.models.Profissional;

public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {
}