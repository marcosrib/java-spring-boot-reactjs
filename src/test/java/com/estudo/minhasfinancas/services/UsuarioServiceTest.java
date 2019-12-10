package com.estudo.minhasfinancas.services;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.estudo.minhasfinancas.exception.RegraNegocioException;
import com.estudo.minhasfinancas.model.Usuario;
import com.estudo.minhasfinancas.repositories.UsuarioRepository;
import com.estudo.minhasfinancas.servicesi.impl.UsuarioServiceImpl;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@TestInstance(Lifecycle.PER_CLASS)
public class UsuarioServiceTest {

	UsuarioService service;
	@MockBean
	UsuarioRepository repo;

	@BeforeAll
	public void setUp() {
		// repo = Mockito.mock(UsuarioRepository.class);
		service = new UsuarioServiceImpl(repo);
	}

	@Test
	public void deveAutenticarUmUsuario() {
		// cenario
		String email = "marcos@gmail";
		String senha = "1234";
		Usuario usuario = new Usuario();
		usuario.setEmail(email);
		usuario.setSenha(senha);
		usuario.setId(1L);
		Mockito.when(repo.findByEmail(email)).thenReturn(Optional.of(usuario));

		// acao
		Usuario result = service.autenticar(email, senha);

		// Verificação

		Assertions.assertThat(result).isNotNull();
	}

	@Test
	public void deveValidarEmail() {
		// cenario

		Mockito.when(repo.existsByEmail(Mockito.anyString())).thenReturn(false);
		// acao
		service.validarEmail("marcos@gmail.com");
	}

	@Test
	public void develancarErroAoValidarEmailQuandoExistirEmailCadastrado() {
		// cenario
		Mockito.when(repo.existsByEmail(Mockito.anyString())).thenReturn(true);

		// acao

		assertThrows(RegraNegocioException.class, () -> service.validarEmail("marcos@gmail.com"));

	}
}
