package com.tistory.hskimsky.jcommander.validator;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * PositiveInteger
 *
 * @author Haneul, Kim
 */
public class PositiveInteger implements IParameterValidator {

  private static final Logger logger = LoggerFactory.getLogger(PositiveInteger.class);

  public void validate(String name, String value) throws ParameterException {
    logger.debug("name = {}, value = {}", name, value);
    int n = Integer.parseInt(value);
    if (n < 0) {
      throw new ParameterException("Parameter " + name + " should be positive (found " + value + ")");
    }
  }
}
