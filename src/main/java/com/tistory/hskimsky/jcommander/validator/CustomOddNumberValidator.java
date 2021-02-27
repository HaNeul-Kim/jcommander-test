package com.tistory.hskimsky.jcommander.validator;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * CustomOddNumberValidator
 *
 * @author Haneul, Kim
 */
public class CustomOddNumberValidator implements IParameterValidator {

  private static final Logger logger = LoggerFactory.getLogger(CustomOddNumberValidator.class);

  @Override
  public void validate(String name, String value) throws ParameterException {
    logger.debug("name = {}, value = {}", name, value);
    int n = Integer.parseInt(value);
    if (n % 2 == 0) {
      throw new ParameterException("Parameter " + name + " should be odd (found " + value + ")");
    }
  }
}
