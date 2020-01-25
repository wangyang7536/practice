package org.ocean.practice.common;

public class EnumTest {
  static enum Type {
    APPLE, ORANGE
  }

  public static void main(String[] args) {
    int[] arr = new int[Type.values().length];
    Type t = Type.ORANGE;
    arr[t.ordinal()] = 10;
    for (int i : arr) {
      System.out.println(i);
    }
    System.out.println(t.equals(Type.ORANGE));
  }
}
