package com.tistory.hskimsky.jcommander.splitter;

import com.beust.jcommander.converters.IParameterSplitter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * SemiColonSplitter
 *
 * @author Haneul, Kim
 */
public class SemiColonSplitter implements IParameterSplitter {

  private static final Logger logger = LoggerFactory.getLogger(SemiColonSplitter.class);

  public List<String> split(String value) {
    logger.debug("value = {}", value);
    return Arrays.asList(value.split(";"));
  }
}
