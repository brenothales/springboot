package com.produtos.apirest.util;

import java.io.File;

/**
 * ReadFilesWord
 */

public class ReadFilesWord implements java.io.FileFilter {
  @Override
  public boolean accept(File file) {
      return file != null &&
          file.isFile() &&
          file.canRead() &&
          (file.getName().endsWith("doc")
          || file.getName().endsWith("docx"));
  }
}
