package com.tistory.hskimsky.model;

import com.beust.jcommander.SubParameter;

/**
 * @author hskimsky
 * @version 1.0
 * @since 2021-02-27
 */
public class MvParameters {

  @SubParameter(order = 0)
  public String from;

  @SubParameter(order = 1)
  public String to;
}
