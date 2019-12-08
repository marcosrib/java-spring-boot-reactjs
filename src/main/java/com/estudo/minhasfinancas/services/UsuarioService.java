package com.estudo.minhasfinancas.services;

import com.estudo.minhasfinancas.model.Usuario;

public interface UsuarioService {
	
	Usuario autenticar(String email, String senha);
  
	Usuario salvarUsuario(Usuario usuario);
	
	void validarEmail(String email);
}
