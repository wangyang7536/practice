package org.ocean.practice.common;

import java.util.HashMap;
import java.util.Map;

public class CollectionTest {
  public static void main(String[] args) {
    Map<String, String> map = new HashMap<>();
    map.put("key1", "apple");
    printCollection(map);
  }

  public static void printCollection(Map<String, String> map) {
    System.out.println(map.keySet());
    System.out.println(map.values());
  }
}
