package org.ocean.practice.string;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringBuilderTest {
  public static void main(String[] args) {
    System.out.println(appendStr("metric1", "timer", "all"));
  }

  private static String appendStr(String name, String... tags) {
    return name + Arrays.asList(tags).stream().collect(Collectors.joining());
  }
}
