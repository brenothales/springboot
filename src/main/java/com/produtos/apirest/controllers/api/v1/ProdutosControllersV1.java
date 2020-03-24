package com.produtos.apirest.controllers.api.v1;


import java.util.List;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;

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
@Api(value = "API REST Produtos")
@CrossOrigin(origins = "*")
public class ProdutosControllersV1 {

  @Autowired
  ProdutoRepository produtoRepository;

  @GetMapping("/produtos")
  @ApiOperation(value = "Retorna uma lista com todos os produtos")
  public List<Produto> index(){
   return produtoRepository.findAll();
  }

  @GetMapping("/produto/show/{id}")
  @ApiOperation(value = "Retorna somente um produto pelo seu identificador (id)")
  public Produto show(@PathVariable(value = "id") long id){
   return produtoRepository.findById(id);
  }

  @PostMapping("/produto/new")
  @ApiOperation(value = "Cria um novo objeto a partir da rota")
  public Produto create(@RequestBody Produto produto){
    return produtoRepository.save(produto);
  }

  @PutMapping("/produto")
  @ApiOperation(value = "Atualiza o objeto")
  public Produto update(@RequestBody Produto produto){
    return produtoRepository.save(produto);
  }

  @DeleteMapping("/produto")
  @ApiOperation(value = "Deleta o registro a partir a rota")
  public void destroy(@RequestBody Produto produto){
    produtoRepository.delete(produto);
  }

}