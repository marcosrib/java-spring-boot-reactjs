package com.estudo.minhasfinancas.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudo.minhasfinancas.model.Usuario;
import com.estudo.minhasfinancas.repositories.UsuarioRepository;
@RestController
public class UsuarioController {
	@Autowired
	UsuarioRepository repo;
	
    @PostMapping("/usuario")
    public ResponseEntity<String> insertCustomers() {        
        Usuario c1 = new Usuario();
        c1.setEmail("marcos@gmail.com");
        c1.setNome("marcos");
        Usuario c2 = new Usuario();
        c2.setEmail("jose@gmail.com");
        c2.setNome("jose");
       // List<Usuario> customers = Arrays.asList(c1, c2);
       // repo.saveAll(customers);
        return ResponseEntity.ok().body("salvou");
    }
}
