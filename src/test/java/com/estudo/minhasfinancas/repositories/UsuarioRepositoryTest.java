package com.estudo.minhasfinancas.repositories;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.estudo.minhasfinancas.model.Usuario;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class UsuarioRepositoryTest {
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Test
	public void deveVerificarAExistenciaDeUmEmail() {
		// cenario
		Usuario usuario = new Usuario();
		usuario.setEmail("marcos@gmail.com");
		usuario.setNome("marcoa");
		
		usuarioRepository.save(usuario);

		// ação/ execução
		boolean result =usuarioRepository.existsByEmail("marcos@gmail.com");
		//verificação
		Assertions.assertThat(result).isTrue();
	}
}
