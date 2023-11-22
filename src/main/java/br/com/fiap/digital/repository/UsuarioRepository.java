package br.com.fiap.digital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.digital.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
