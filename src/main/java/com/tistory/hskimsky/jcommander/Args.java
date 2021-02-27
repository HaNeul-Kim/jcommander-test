package com.tistory.hskimsky.jcommander;

import com.beust.jcommander.DynamicParameter;
import com.beust.jcommander.Parameter;
import com.tistory.hskimsky.jcommander.converter.FileConverter;
import com.tistory.hskimsky.jcommander.converter.FileListConverter;
import com.tistory.hskimsky.jcommander.splitter.SemiColonSplitter;
import com.tistory.hskimsky.jcommander.validator.CustomOddNumberValidator;
import com.tistory.hskimsky.jcommander.validator.PositiveInteger;
import com.tistory.hskimsky.model.HostPort;
import com.tistory.hskimsky.model.MvParameters;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * args test class
 *
 * @author Haneul, Kim
 */
public class Args {

  @Parameter(description = "Parameters")
  private List<String> parameters = new ArrayList<>();

  @Parameter(names = {"-log", "-verbose"}, description = "Level of verbosity")
  private Integer verbose = 1;

  @Parameter(names = "-groups", description = "Comma-separated list of group names to be run")
  private String groups;

  @Parameter(names = "-debug", description = "Debug mode", arity = 1)
  private boolean debug = false;

  @Parameter(names = "-host", description = "The host")
  private List<String> hosts = new ArrayList<>();

  @Parameter(names = "-password", description = "Connection password", password = true, echoInput = true)
  private String password;

  @DynamicParameter(names = "-D", description = "Dynamic parameters go here")
  private Map<String, String> params = new HashMap<>();

  @Parameter(names = "-file", converter = FileConverter.class)
  private File file;

  @Parameter(names = "-files1", converter = FileConverter.class)
  private List<File> files1;

  @Parameter(names = "-files2", converter = FileListConverter.class)
  private List<List<File>> files2;

  @Parameter(names = "-files3", converter = FileConverter.class, splitter = SemiColonSplitter.class)
  private List<File> files3;

  @Parameter(names = "-hostport")
  private HostPort hostPort;

  @Parameter(names = "-age", validateWith = PositiveInteger.class)
  private Integer age;

  @Parameter(names = "-count", validateWith = {PositiveInteger.class, CustomOddNumberValidator.class})
  private Integer count;

  // com.beust.jcommander.ParameterException: Only one @Parameter with no names attribute is allowed
  // Main parameter
  // @Parameter(description = "Files")
  // private List<String> files;

  @Parameter(names = "-pairs", arity = 2, description = "Pairs")
  private List<String> pairs;

  @Parameter(names = "-foo1", variableArity = true)
  private List<String> foo1 = new ArrayList<>();

  @Parameter(names = "-foo2", variableArity = true)
  private List<String> foo2 = new ArrayList<>();

  @Parameter(names = {"--mv"}, arity = 2)
  private MvParameters mvParameters;

  @Parameter(names = "-requiredHost", required = true)
  private String requiredHost;

  public List<String> getParameters() {
    return parameters;
  }

  public Integer getVerbose() {
    return verbose;
  }

  public String getGroups() {
    return groups;
  }

  public boolean isDebug() {
    return debug;
  }

  public List<String> getHosts() {
    return hosts;
  }

  public String getPassword() {
    return password;
  }

  public Map<String, String> getParams() {
    return params;
  }

  public File getFile() {
    return file;
  }

  public List<File> getFiles1() {
    return files1;
  }

  public List<List<File>> getFiles2() {
    return files2;
  }

  public List<File> getFiles3() {
    return files3;
  }

  public HostPort getHostPort() {
    return hostPort;
  }

  public Integer getAge() {
    return age;
  }

  public Integer getCount() {
    return count;
  }

  public List<String> getPairs() {
    return pairs;
  }

  public List<String> getFoo1() {
    return foo1;
  }

  public List<String> getFoo2() {
    return foo2;
  }

  public MvParameters getMvParameters() {
    return mvParameters;
  }

  public String getRequiredHost() {
    return requiredHost;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Args args = (Args) o;
    return debug == args.debug &&
      parameters.equals(args.parameters) &&
      verbose.equals(args.verbose) &&
      groups.equals(args.groups) &&
      hosts.equals(args.hosts) &&
      password.equals(args.password) &&
      params.equals(args.params) &&
      file.equals(args.file) &&
      files1.equals(args.files1) &&
      files2.equals(args.files2) &&
      files3.equals(args.files3) &&
      hostPort.equals(args.hostPort) &&
      age.equals(args.age) &&
      count.equals(args.count) &&
      pairs.equals(args.pairs) &&
      foo1.equals(args.foo1) &&
      foo2.equals(args.foo2) &&
      mvParameters.equals(args.mvParameters) &&
      requiredHost.equals(args.requiredHost);
  }

  @Override
  public int hashCode() {
    return Objects.hash(parameters, verbose, groups, debug, hosts, password, params,
      file, files1, files2, files3, hostPort, age, count, pairs, foo1, foo2, mvParameters,
      requiredHost);
  }

  @Override
  public String toString() {
    return "Args{" +
      "\nparameters=" + parameters +
      "\n, verbose=" + verbose +
      "\n, groups='" + groups + '\'' +
      "\n, debug=" + debug +
      "\n, hosts=" + hosts +
      "\n, password='" + password + '\'' +
      "\n, params=" + params +
      "\n, file=" + file +
      "\n, files1=" + files1 +
      "\n, files2=" + files2 +
      "\n, files3=" + files3 +
      "\n, hostPort=" + hostPort +
      "\n, age=" + age +
      "\n, count=" + count +
      "\n, pairs=" + pairs +
      "\n, foo1=" + foo1 +
      "\n, foo2=" + foo2 +
      "\n, mvParameters=" + mvParameters +
      "\n, requiredHost=" + requiredHost +
      '}';
  }
}
