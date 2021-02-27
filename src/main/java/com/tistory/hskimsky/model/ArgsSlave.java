package com.tistory.hskimsky.model;

import com.beust.jcommander.Parameter;

import java.util.Objects;

/**
 * ArgsSlave
 *
 * @author Haneul, Kim
 */
public class ArgsSlave {

  @Parameter(names = "-slave")
  private String slave;

  public String getSlave() {
    return slave;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ArgsSlave argsSlave = (ArgsSlave) o;
    return slave.equals(argsSlave.slave);
  }

  @Override
  public int hashCode() {
    return Objects.hash(slave);
  }

  @Override
  public String toString() {
    return "ArgsSlave{" +
      "slave='" + slave + '\'' +
      '}';
  }
}
