package com.tistory.hskimsky.jcommander.converter;

import com.beust.jcommander.IStringConverter;
import com.tistory.hskimsky.model.HostPort;

/**
 * HostPortConverter
 *
 * @author Haneul, Kim
 */
public class HostPortConverter implements IStringConverter<HostPort> {
  @Override
  public HostPort convert(String value) {
    String[] s = value.split(":");
    return new HostPort(s[0], Integer.parseInt(s[1]));
  }
}
