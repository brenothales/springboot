package com.produtos.apirest.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Vaga
 */
@Entity
@Table(name = "vaga")
@Data
@NoArgsConstructor
public class Vaga implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String lotacao;
  private String tipo_de_vaga;
  private String tipo_do_ensino;
  private String descricao;
  private String area_do_conhecimento;
  private Date aplicacao;
  private String detalhes;

}