package com.estudo.minhasfinancas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudo.minhasfinancas.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	boolean existsByEmail(String email);
}
