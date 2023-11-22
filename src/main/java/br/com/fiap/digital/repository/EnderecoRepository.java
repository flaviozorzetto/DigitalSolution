package br.com.fiap.digital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.digital.models.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
