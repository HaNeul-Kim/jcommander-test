package com.tistory.hskimsky.jcommander.factory;

import com.beust.jcommander.IStringConverter;
import com.beust.jcommander.IStringConverterFactory;
import com.tistory.hskimsky.model.HostPort;
import com.tistory.hskimsky.jcommander.converter.HostPortConverter;

/**
 * HostPortConverterFactory
 *
 * @author Haneul, Kim
 */
public class Factory implements IStringConverterFactory {
  public Class<? extends IStringConverter<?>> getConverter(Class forType) {
    return forType.equals(HostPort.class) ? HostPortConverter.class : null;
  }
}
