package com.produtos.apirest.repository;

import com.produtos.apirest.models.Ementa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmentasRepository extends JpaRepository<Ementa, Long >{
  Ementa findById(long id);
}

