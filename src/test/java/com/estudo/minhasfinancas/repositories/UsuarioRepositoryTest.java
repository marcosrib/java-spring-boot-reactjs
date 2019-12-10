package com.estudo.minhasfinancas.repositories;

import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.EntityManager;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.estudo.minhasfinancas.model.Usuario;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class UsuarioRepositoryTest {
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private TestEntityManager entityManager;

	@Test
	public void deveVerificarAExistenciaDeUmEmail() {
		// cenario
		Usuario usuario = new Usuario();
		usuario.setEmail("marcos@gmail.com");
		usuario.setNome("marcoa");

		entityManager.persist(usuario);

		// ação/ execução
		boolean result = usuarioRepository.existsByEmail("marcos@gmail.com");
		// verificação
		Assertions.assertThat(result).isTrue();
	}

	@Test
	public void deveRetornarFalsoQuandoNaoHouverUsuarioCadastradoComOemail() {
		// cenario

		// acao
		boolean result = usuarioRepository.existsByEmail("marcos@gmail.com");

		// verificação

		Assertions.assertThat(result).isFalse();
	}

	@Test
	public void devePersistirUmUsuarioNaBaseDeDados() {
		// cenario
		Usuario usuario = criarUsuario();
		// acao
		Usuario usuarioSalvo = usuarioRepository.save(usuario);
		// verificação
		Assertions.assertThat(usuarioSalvo.getId()).isNotNull();
	}

	@Test
	public void deveBuscarUsuario() {
		// cenario
		Usuario usuario = criarUsuario();
		entityManager.persist(usuario);
		// acao
		Optional<Usuario> result = usuarioRepository.findByEmail("marcos@gmail");
		// verificação
		Assertions.assertThat(result.isPresent()).isTrue();
	}
	
	@Test
	public void deveRetornarVazioAoBuscarUsuarioPorEmailQuandoNaoExistirNaBase() {
		// cenario

		// acao
		Optional<Usuario> result = usuarioRepository.findByEmail("marcos@gmail");
		// verificação
		Assertions.assertThat(result.isPresent()).isFalse();
	}

	public static Usuario criarUsuario() {
		Usuario usuario = new Usuario();
		usuario.setNome("marcos");
		usuario.setEmail("marcos@gmail");
		usuario.setSenha("1234");
		return usuario;
	}
}
