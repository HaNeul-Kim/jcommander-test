package com.tistory.hskimsky.jcommander.converter;

import com.beust.jcommander.IStringConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * FileListConverter
 *
 * @author Haneul, Kim
 */
public class FileListConverter implements IStringConverter<List<File>> {

  private static final Logger logger = LoggerFactory.getLogger(FileListConverter.class);

  @Override
  public List<File> convert(String files) {
    String[] paths = files.split(",");
    List<File> fileList = new ArrayList<>();
    for (String path : paths) {
      fileList.add(new File(path));
    }
    logger.debug("fileList = {}", fileList);
    return fileList;
  }
}
