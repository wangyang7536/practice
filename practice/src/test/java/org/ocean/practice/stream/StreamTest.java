package org.ocean.practice.stream;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.junit.Assert;
import org.junit.Test;

public class StreamTest {
  @Test
  public void testAvg() {
    List<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(6);
    int avg = (int) (list.stream().mapToInt(i -> i).average().getAsDouble());
    Assert.assertEquals(3, avg);
  }

  @Test
  public void testUppercase() {
    List<String> list = new ArrayList<>();
    list.add("apple");
    list.add("orange");
    list.add("banana");
    List<String> upperList = list.stream().map(s -> s.toUpperCase()).collect(Collectors.toList());
    Assert.assertTrue(upperList.stream().anyMatch(s -> s.equals("APPLE")));
  }

  @Test
  public void testFilter() {
    List<String> list = new ArrayList<>();
    list.add("app");
    list.add("apple");
    list.add("orange");
    list.add("banana");
    List<String> filterList =
        list.stream().filter(s -> s.toLowerCase().startsWith("a") && s.length() == 3)
            .collect(Collectors.toList());
    Assert.assertTrue(filterList.stream().anyMatch(s -> s.equals("app")));
  }

  @Test
  public void testCommaSplit() {
    List<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(6);
    String result = list.stream().map(i -> i % 2 == 0 ? 'e' + i.toString() : 'o' + i.toString())
        .collect(Collectors.joining(","));
    Assert.assertEquals(result, "o1,e2,o3,e6");
  }

  @Test
  public void testPredicate() {
    boolean b1 = new Predicate<Integer>() {
      @Override
      public boolean test(Integer i) {
        return i % 2 == 0;
      }
    }.test(3);
    Assert.assertFalse(b1);

    boolean b2 = new Predicate<Integer>() {
      @Override
      public boolean test(Integer i) {
        return BigInteger.valueOf(i).isProbablePrime(100);
      }
    }.test(18);
    Assert.assertFalse(b2);

    boolean b3 = new Predicate<Integer>() {
      @Override
      public boolean test(Integer i) {
        return (String.valueOf(i))
            .equals(new StringBuilder(String.valueOf(i)).reverse().toString());
      }
    }.test(12321);
    Assert.assertTrue(b3);
  }
}
