package org.ocean.practice.collection;

import java.util.ArrayList;
import java.util.List;

public class StreamAnyMatchTest {
  public static void main(String[] args) {
    List<String> input = new ArrayList<>();
    input.add("apple");
    input.add("melon");
    input.add("pear");
    input.add("orange");
    System.out.println(validateExistence(input));
  }

  public static boolean validateExistence(List<String> input) {
    return input.stream().anyMatch(item -> item.equals("apple1"));
  }
}
