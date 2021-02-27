package com.tistory.hskimsky.model;

import com.beust.jcommander.Parameter;

/**
 * @author hskimsky
 * @version 1.0
 * @since 2021-02-27
 */
public class Parameters {

  @Parameter(names = {"--mv"}, arity = 2)
  private MvParameters mvParameters;

  public MvParameters getMvParameters() {
    return mvParameters;
  }
}
