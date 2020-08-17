package org.ocean.practice.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class CompareTest {
  public static void main(String[] args) {
    // List<String> l1 = new ArrayList<>();
    // l1.add("2");
    // l1.add("1");
    // l1.add("2");
    // l1.add("3");
    // List<String> l2 = new ArrayList<>();
    // l2.add("1");
    // l2.add("2");
    // l2.add("2");
    // l2.add("3");
    // System.out.println(compareList(l1, l2));
    // System.out.println(containList(l1, l2));
    List<TestObj> list = new ArrayList<>();
    list.add(new TestObj("apple", 1));
    list.add(new TestObj("banana", 3));
    list.add(new TestObj("orange", 2));
    Collections.sort(list, new Comparator<TestObj>() {
      @Override
      public int compare(TestObj o1, TestObj o2) {
        return Long.compare(o1.index, o2.index);
      }
    });
    for (int i = 0; i < 3; i++) {
      System.out.println(list.get(i).val);
    }
  }

  public static boolean compareList(List<String> l1, List<String> l2) {
    return Objects.equals(l1, l2);
  }

  public static boolean containList(List<String> l1, List<String> l2) {
    return l1.containsAll(l2) && l2.containsAll(l1);
  }

  public static class TestObj {
    String val;
    long index;

    public TestObj(String val, long index) {
      this.val = val;
      this.index = index;
    }
  }
}
