package com.tistory.hskimsky.jcommander.converter;

import com.beust.jcommander.IStringConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * FileConverter
 *
 * @author Haneul, Kim
 */
public class FileConverter implements IStringConverter<File> {

  private static final Logger logger = LoggerFactory.getLogger(FileConverter.class);

  @Override
  public File convert(String value) {
    logger.debug("value = {}", value);
    return new File(value);
  }
}
