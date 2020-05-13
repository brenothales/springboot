package com.produtos.apirest.controllers.api.v2;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

import com.produtos.apirest.util.ReadFilesWord;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

// ImportaDocumentoProcessoFileServerServiceImpl

@RestController
@RequestMapping(value = "api/v2/")
@CrossOrigin(origins = "*")
public class ReadDocxFileV2 {

  @Autowired
  EmentasRepository ementasRepository;


  public String path = "/Users/brenothales/dev/java/apirest/src/main/resources/docs/";



  @GetMapping("/doc")
  public void index() {

    try {
      FileFilter filter = new ReadFilesWord();
      File directory = Paths.get(path).toFile();
      File[] files = directory.listFiles(filter);

      int a = 0;
      for (File file : files) {
        InputStream input = new FileInputStream(file);
       //init workbook and do stuff

       // FileInputStream file = new FileInputStream(path + "decisao.docx");
       // Esta class extrairá conteúdo do documento
       XWPFDocument docx = new XWPFDocument(input);
       // getContentInTextBoxandSaveOutherFile(docx);
      //  IBodyElement element = docx.getBodyElements().stream().findFirst().get();
       Iterator<IBodyElement> iterator = docx.getBodyElementsIterator();
       
       while (iterator.hasNext()) {
        IBodyElement element = iterator.next();
         if (element instanceof XWPFSDT) {
           XWPFSDT sdt = (XWPFSDT) element;
           a++;
           System.out.println("------- DOC "+(a)+" ---------");
           printXWPFSDTContent(sdt);
           break;
          }

        }
      }

      // for (XWPFParagraph xwpfParagraph : docx.getParagraphs()) {
      //   String text = xwpfParagraph.getParagraphText(); // here is where you receive text from textbox
        // printContentsOfTextBox(xwpfParagraph);

        // printContentsOfTextBox(xwpfParagraph);
      // }

      // Litagem de paragrafo
      // List<XWPFParagraph> paragraphsList = docx.getParagraphs();

      // for (XWPFParagraph paragraph: paragraphsList){
      // System.out.println(paragraph.getText());
      // }
      // Fim da listagens do paragrafo

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // public void printXWPFSDTContent(XWPFSDT sdt) {
  //   StringBuffer sb = new StringBuffer();
  //   // sb.append("tag:ementa").append(sdt.getTag());
  //   // sb.append("title: ").append(sdt.getTitle());
  //   ISDTContent content = sdt.getContent();
  //   sb.append("").append(content.getText());
  //   System.out.println(sb.toString());
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