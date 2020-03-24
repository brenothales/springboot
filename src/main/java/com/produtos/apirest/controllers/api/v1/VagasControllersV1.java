package com.produtos.apirest.controllers.api.v1;


import java.util.List;

import com.produtos.apirest.models.Vaga;
import com.produtos.apirest.repository.VagasRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/**
 * ProdutosControllersV1
 */
@RestController
@RequestMapping(value = "api/v1")
@Api(value = "API REST Vagas")
@CrossOrigin(origins = "*")
public class VagasControllersV1 {

  @Autowired
  VagasRepository vagasRepository;

  @GetMapping("/vagas")
  @ApiOperation(value = "Retorna uma lista com todos os vagas")
  public List<Vaga> index(){
   return vagasRepository.findAll();
  }

  @GetMapping("/vaga/show/{id}")
  @ApiOperation(value = "Retorna somente uma vaga pelo seu identificador (id)")
  public Vaga show(@PathVariable(value = "id") long id){
   return vagasRepository.findById(id);
  }

  @PostMapping("/vaga/new")
  @ApiOperation(value = "Cria um novo objeto a partir da rota")
  public Vaga create(@RequestBody Vaga vaga){
    return vagasRepository.save(vaga);
  }

  @PutMapping("/vaga")
  @ApiOperation(value = "Atualiza o objeto")
  public Vaga update(@RequestBody Vaga vaga){
    return vagasRepository.save(vaga);
  }

  @DeleteMapping("/vaga")
  @ApiOperation(value = "Deleta o registro a partir a rota")
  public void destroy(@RequestBody Vaga vaga){
    vagasRepository.delete(vaga);
  }

}