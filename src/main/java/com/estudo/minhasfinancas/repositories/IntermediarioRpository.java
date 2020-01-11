package com.estudo.minhasfinancas.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.estudo.minhasfinancas.model.Intermediario;
import com.estudo.minhasfinancas.model.Module;
import com.estudo.minhasfinancas.model.Usert;


public interface IntermediarioRpository  extends JpaRepository<Intermediario, Long>{
    @Transactional
    @Modifying
    @Query(value = "delete from Intermediario i  where i.module  in (:module) and i.usert  in (:usert)") 
	void deleteModuleAndUsert(@Param("module") List<Module> module, @Param("usert") List<Usert> usert);
  
    @Query(value = "select i from Intermediario i  where i.module = :module and i.usert = :usert") 
    List<Intermediario> buscaModuloUsuario(@Param("module") Module module, @Param("usert") Usert usert);
    
   
}
