package org.ocean.practice.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListToSetTest {
  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    list.add("apple");
    list.add("apple");
    list.add("apple");
    list.add("orange");
    list.add("pear");
    list.add("banana");
    listToSet(list);
  }

  public static void listToSet(List<String> list) {
    Set<String> set = new HashSet<>(list);
    for (String item : set) {
      System.out.print(item + " ");
    }
  }
}
