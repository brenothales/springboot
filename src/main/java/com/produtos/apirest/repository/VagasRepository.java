package com.produtos.apirest.repository;

import com.produtos.apirest.models.Vaga;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * VagasRepository
 */
public interface VagasRepository extends JpaRepository<Vaga, Long> {

  Vaga findById(long id);

}