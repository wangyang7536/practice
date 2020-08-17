package org.ocean.practice.string;

import java.util.UUID;

public class StringHash {
  public static void main(String[] args) {
    String str = UUID.randomUUID().toString();
    System.out.println(str);
    System.out.println(str.hashCode());
    System.out.println(hashCode(str));
  }

  public static int hashCode(String str) {
    final int prime = 7;
    int result = 1;
    result = prime * result + ((str == null) ? 0 : str.hashCode());
    return result;
  }
}
