package com.tistory.hskimsky.model;

import com.beust.jcommander.Parameter;

import java.util.Objects;

/**
 * ArgsMaster
 *
 * @author Haneul, Kim
 */
public class ArgsMaster {

  @Parameter(names = "-master")
  private String master;

  public String getMaster() {
    return master;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ArgsMaster that = (ArgsMaster) o;
    return master.equals(that.master);
  }

  @Override
  public int hashCode() {
    return Objects.hash(master);
  }

  @Override
  public String toString() {
    return "ArgsMaster{" +
      "master='" + master + '\'' +
      '}';
  }
}
