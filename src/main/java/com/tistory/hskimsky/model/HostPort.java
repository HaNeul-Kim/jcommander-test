package com.tistory.hskimsky.model;

import java.util.Objects;

/**
 * HostPort
 *
 * @author Haneul, Kim
 */
public class HostPort {

  private final String host;
  private final int port;

  public HostPort(String host, int port) {
    this.host = host;
    this.port = port;
  }

  public String getHost() {
    return host;
  }

  public int getPort() {
    return port;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HostPort hostPort = (HostPort) o;
    return port == hostPort.port &&
      host.equals(hostPort.host);
  }

  @Override
  public int hashCode() {
    return Objects.hash(host, port);
  }

  @Override
  public String toString() {
    return "HostPort{" +
      "host='" + host + '\'' +
      ", port=" + port +
      '}';
  }
}
