package com.produtos.apirest.controllers.api.v1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import com.produtos.apirest.models.Ementa;
import com.produtos.apirest.repository.EmentasRepository;

import org.apache.poi.xwpf.usermodel.IBodyElement;
import org.apache.poi.xwpf.usermodel.ISDTContent;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import org.apache.poi.xwpf.usermodel.XWPFSDT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "api/v1/")
@CrossOrigin(origins = "*")
public class ReadDocxFileV1 {
  public String path = "/Users/brenothales/dev/java/apirest/src/main/resources/docs/";

  @Autowired
  EmentasRepository ementasRepository;

  @GetMapping("/doc")
  public void index() {

    try {
      FileInputStream file = new FileInputStream(path + "decisão definitiva 1.docx");
      XWPFDocument docx = new XWPFDocument(file);
      Iterator<IBodyElement> iterator = docx.getBodyElementsIterator();

      while (iterator.hasNext()) {
        IBodyElement element = iterator.next();
        if (element instanceof XWPFSDT) {
          XWPFSDT sdt = (XWPFSDT) element;
          printXWPFSDTContent(sdt);
          break;
        }

      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  
  // @PostMapping("/ementa/new")
  // @ApiOperation(value = "Cria um novo objeto a partir da rota")
  // public Ementa create(@RequestBody Ementa ementa){
  //   System.out.println(ementa.getEmenta());
  //   return ementasRepository.save(ementa);
  // }

  public void printXWPFSDTContent(XWPFSDT sdt) {
    // StringBuffer sb = new StringBuffer();
    ISDTContent content = sdt.getContent();
    // sb.append("").append(content.getText());
    Ementa ementa = new Ementa();
    ementa.setEmenta(content.getText());
    ementasRepository.save(ementa);
    System.out.println(ementa.getEmenta());
  }

  @GetMapping("/ementas/all")
  @ApiOperation(value = "Retorna todas as ementas")
  public List<Ementa> all(){
   return ementasRepository.findAll();
  }



}