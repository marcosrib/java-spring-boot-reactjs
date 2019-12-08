package com.estudo.minhasfinancas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudo.minhasfinancas.model.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {

}
