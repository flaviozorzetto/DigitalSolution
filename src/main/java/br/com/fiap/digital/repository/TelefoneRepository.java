package br.com.fiap.digital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.digital.models.Telefone;

public interface TelefoneRepository extends JpaRepository<Telefone, Long> {
}