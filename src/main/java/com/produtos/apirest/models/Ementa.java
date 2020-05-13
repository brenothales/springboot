package com.produtos.apirest.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
  * Ementa
  */

@Entity
@Table(name = "ementa")
@Data
@NoArgsConstructor
public class Ementa implements Serializable{

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(columnDefinition="TEXT")
  private String ementa;

}

