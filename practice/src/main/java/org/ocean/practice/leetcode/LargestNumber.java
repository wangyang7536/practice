package org.ocean.practice.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {
  public static void main(String[] args) {
    int[] nums = {3, 30, 34, 5, 9};
    System.out.println(largestNumber(nums));
  }

  public static String largestNumber(int[] nums) {
    List<String> list = new ArrayList<>();
    for (int n : nums) {
      list.add(String.valueOf(n));
    }
    Collections.sort(list, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        String o1o2 = o1 + o2;
        String o2o1 = o2 + o1;
        return o2o1.compareTo(o1o2);
      }
    });
    StringBuilder sb = new StringBuilder();
    for (String s : list) {
      sb.append(s);
    }
    if (sb.charAt(0) == '0')
      return "0";
    return sb.toString();
  }
}
