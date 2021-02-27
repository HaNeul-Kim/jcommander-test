package com.tistory.hskimsky;

import com.beust.jcommander.IDefaultProvider;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.internal.Maps;
import com.tistory.hskimsky.jcommander.Args;
import com.tistory.hskimsky.jcommander.factory.Factory;
import com.tistory.hskimsky.model.ArgsMaster;
import com.tistory.hskimsky.model.ArgsSlave;
import com.tistory.hskimsky.model.HostPort;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;

/**
 * JCommanderTest
 *
 * https://jcommander.org/
 *
 * @author Haneul, Kim
 */
public class JCommanderTest {

  private static final Logger logger = LoggerFactory.getLogger(JCommanderTest.class);

  private static final IDefaultProvider DEFAULT_PROVIDER = new IDefaultProvider() {
    @Override
    public String getDefaultValueFor(String optionName) {
      logger.debug("optionName = {}", optionName);
      return "-debug".equals(optionName) ? "false" : "42";
    }
  };

  @Test
  public void argsTest() {
    Args args = new Args();
    String[] argv = {
      "-log", "2"
      , "-groups", "unit"
      , "-parameters", "a"
      , "-debug", "true"
      , "-Da=aa", "-Db=bb", "-D", "c=cc"
      , "-password", "changeme"
      , "-host", "host1,host2"
      , "-file", "F:\\vm\\linux\\kube"
      , "-files1", "F:\\vm\\linux\\kube\\instance-1,E:\\vm\\linux\\kube\\instance-2"
      , "-files2", "F:\\vm\\linux\\kube\\instance-3"
      , "-files3", "F:\\vm\\linux\\kube\\instance-5;E:\\vm\\linux\\kube\\instance-4"
      , "-hostport", "www.naver.com:80"
      , "-age", "34"
      , "-count", "33"
      , "-pairs", "slave", "master"
      , "-foo1", "a1", "a2"
      , "-foo2", "a1"
      , "--mv", "sky.local", "docker.io"
      , "-requiredHost", "test.sky.local"
    };
    JCommander.newBuilder()
      .addObject(args)
      .addConverterFactory(new Factory())
      .build()
      .parse(argv);
    JCommander jCommander = JCommander.newBuilder()
      .addObject(args)
      .addConverterFactory(new Factory())
      // .defaultProvider(DEFAULT_PROVIDER)
      .build();
    // jCommander.setCaseSensitiveOptions(true);
    // jCommander.setAllowAbbreviatedOptions(true);// -par 를 입력해서 -param 지정. 모호한 경우 ParameterException
    jCommander.parse(argv);
    Assert.assertEquals(new Integer(2), args.getVerbose());
    Assert.assertEquals("unit", args.getGroups());
    Assert.assertTrue(args.isDebug());
    Assert.assertEquals(Arrays.asList("host1", "host2"), args.getHosts());
    Assert.assertEquals("changeme", args.getPassword());
    Assert.assertEquals(Maps.newHashMap("a", "aa", "b", "bb", "c", "cc"), args.getParams());
    Assert.assertEquals(new File("F:\\vm\\linux\\kube"), args.getFile());
    Assert.assertEquals(Arrays.asList(
      new File("F:\\vm\\linux\\kube\\instance-1"),
      new File("E:\\vm\\linux\\kube\\instance-2")
    ), args.getFiles1());
    Assert.assertEquals(
      Collections.singletonList(
        Collections.singletonList(
          new File("F:\\vm\\linux\\kube\\instance-3")
        )
      )
      , args.getFiles2());
    Assert.assertEquals(Arrays.asList(
      new File("F:\\vm\\linux\\kube\\instance-5"),
      new File("E:\\vm\\linux\\kube\\instance-4")
    ), args.getFiles3());
    Assert.assertEquals(new HostPort("www.naver.com", 80), args.getHostPort());
    Assert.assertEquals(new Integer(34), args.getAge());
    Assert.assertEquals(new Integer(33), args.getCount());
    Assert.assertEquals(Arrays.asList("slave", "master"), args.getPairs());
    Assert.assertEquals(Arrays.asList("a1", "a2"), args.getFoo1());
    Assert.assertEquals(Collections.singletonList("a1"), args.getFoo2());
    Assert.assertEquals("sky.local", args.getMvParameters().from);
    Assert.assertEquals("docker.io", args.getMvParameters().to);
    Assert.assertEquals("test.sky.local", args.getRequiredHost());
  }

  /**
   * @link https://jcommander.org/#_multiple_descriptions
   */
  @Test
  public void multipleDescriptionsTest() {
    ArgsMaster m = new ArgsMaster();
    ArgsSlave s = new ArgsSlave();

    String[] argv = {"-master", "km1", "-slave", "kw1"};
    JCommander.newBuilder()
      .addObject(new Object[]{m, s})
      .build()
      .parse(argv);
    Assert.assertEquals("km1", m.getMaster());
    Assert.assertEquals("kw1", s.getSlave());
  }
}
