package br.com.fiap.digital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.digital.models.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
}