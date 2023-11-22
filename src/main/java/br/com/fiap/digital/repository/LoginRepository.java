package br.com.fiap.digital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.digital.models.Login;

public interface LoginRepository extends JpaRepository<Login, Long> {
}
