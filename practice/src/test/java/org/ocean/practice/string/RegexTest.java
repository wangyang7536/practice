package org.ocean.practice.string;

import java.util.Arrays;
import java.util.List;

public class RegexTest {
  public static void main(String[] args) {
    String cmd = "sudo ls -l /Users/hcd/Workspace/practice/practice/src/test/resources";
    String regex = "\\s+";
    List<String> result = splitByRegex(cmd, regex);
    System.out.println(result);

    String input = "/boot/efi";
    String regex2 = "^/.*";
    System.out.println(matchRegex(input, regex2));
  }

  public static List<String> splitByRegex(String input, String regex) {
    return Arrays.asList(input.split(regex));
  }

  public static boolean matchRegex(String input, String regex) {
    return input.matches(regex);
  }
}
