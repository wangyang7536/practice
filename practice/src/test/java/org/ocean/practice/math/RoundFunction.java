package org.ocean.practice.math;

public class RoundFunction {
  public static void main(String[] args) {
    System.out.println(round(1023));
    System.out.println(64l * (1l << 30l));
    System.out.println((long) (1.2 * 56l));
  }

  public static long round(long val) {
    if (val == 0) {
      return 0;
    }
    val = (val >> 1) | val;
    val = (val >> 2) | val;
    val = (val >> 4) | val;
    val = (val >> 8) | val;
    val = (val >> 16) | val;
    val = (val >> 32) | val;
    val = val - (val >> 1);
    return val;
  }
}
