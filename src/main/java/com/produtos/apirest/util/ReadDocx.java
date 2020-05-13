package com.produtos.apirest.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;


public class ReadDocx {


  try {
    FileInputStream file = new FileInputStream("documento.docx");
    //Esta class extrairá conteúdo do documento
    XWPFDocument docx = new XWPFDocument(file);
    List<XWPFParagraph> paragraphsList = docx.getParagraphs();

    for (XWPFParagraph paragraph: paragraphsList){
        System.out.println(paragraph.getText());
    }


  } catch (FileNotFoundException e) {
    e.printStackTrace();
  } catch (IOException e){
    e.printStackTrace();
  }


}