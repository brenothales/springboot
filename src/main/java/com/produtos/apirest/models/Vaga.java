package com.produtos.apirest.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Vaga
 */
@Entity
@Table(name = "vaga")
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

  public long getId() {
    return id;
  }

  public Date getAplicacao() {
    return aplicacao;
  }

  public void setAplicacao(Date aplicacao) {
    this.aplicacao = aplicacao;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getLotacao() {
    return lotacao;
  }

  public void setLotacao(String lotacao) {
    this.lotacao = lotacao;
  }

  public String getTipo_de_vaga() {
    return tipo_de_vaga;
  }

  public void setTipo_de_vaga(String tipo_de_vaga) {
    this.tipo_de_vaga = tipo_de_vaga;
  }

  public String getTipo_do_ensino() {
    return tipo_do_ensino;
  }

  public void setTipo_do_ensino(String tipo_do_ensino) {
    this.tipo_do_ensino = tipo_do_ensino;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public String getArea_do_conhecimento() {
    return area_do_conhecimento;
  }

  public void setArea_do_conhecimento(String area_do_conhecimento) {
    this.area_do_conhecimento = area_do_conhecimento;
  }

  public String getDetalhes() {
    return detalhes;
  }

  public void setDetalhes(String detalhes) {
    this.detalhes = detalhes;
  }



}