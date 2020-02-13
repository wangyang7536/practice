package org.ocean.practice.string;

import java.util.ArrayList;
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

    System.out.println(matchRegex("0000:03:00.0", "^....:..:..\\.."));
    String line =
        "/devices/pci0000:00/0000:00:1c.0/0000:03:00.0/host0/port-0:2/end_device-0:2/target0:0:2/0:0:2:0/block/sdc";
    System.out.println(getPci(line));

    String deviceName1 = "sda";
    String regex3 = "sd[a-z]";
    System.out.println(matchRegex(deviceName1, regex3));

    List<String> output = new ArrayList<>();
    output.add("/dev/sdc       480590568K 18875404K 437279452K   5% /mnt/S3Z1NB0K409467N");
    String regex4 = "^/dev/sdc.*$";
    output.removeIf(string -> regex4 != null && !string.matches(regex4));
    System.out.println(output);
  }

  public static String getPci(String line) {
    List<String> list = Arrays.asList(line.split("/"));
    int index = 0;
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).toLowerCase().startsWith("pci")) {
        index = i;
        break;
      }
    }
    index++;
    String result = "";
    for (int j = index; j < list.size(); j++) {
      if (list.get(j).matches("^....:..:..\\..")) {
        String[] tmp = list.get(j).split(":");
        result = tmp[1];
      }
    }
    return result;
  }

  public static List<String> splitByRegex(String input, String regex) {
    return Arrays.asList(input.split(regex));
  }

  public static boolean matchRegex(String input, String regex) {
    return input.matches(regex);
  }
}
