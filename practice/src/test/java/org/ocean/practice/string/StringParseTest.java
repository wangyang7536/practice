package org.ocean.practice.string;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringParseTest {
  public static void main(String[] args) {
    String line = "Serial Number '        Z4JS104VTM9W'   ";
    List<String> input = new ArrayList<>();
    input.add(line);
    input.add("   ");
    System.out.println(parse(input));

    List<String> outputList = readText("src/test/resources/device_info_list");
    String deviceLine = "[0:0:2:0]    disk    sas:0x1221000002000000          /dev/sdc ";
    System.out.println(verify(outputList, deviceLine.trim()));
  }

  public static String parse(List<String> input) {
    String output = null;
    for (String inputLine : input) {
      if (inputLine.contains("Serial Number")) {
        int startIndex = inputLine.indexOf('\'');
        int endIndex = inputLine.lastIndexOf('\'');
        output = inputLine.substring(startIndex + 1, endIndex).trim();
        break;
      }
    }
    return output;
  }

  public static List<String> readText(String path) {
    List<String> outputList = new ArrayList<>();
    try (Stream<String> lines = Files.lines(Paths.get(path))) {
      outputList = lines.collect(Collectors.toList());
    } catch (IOException e) {
      e.printStackTrace();
    }
    return outputList;
  }

  public static boolean verify(List<String> outputList, String line) {
    int index = 0;
    for (int i = 0; i < outputList.size(); i++) {
      if (outputList.get(i).trim().equals(line)) {
        index = i;
        break;
      }
    }
    String transport = null;
    String targetPort = null;
    for (String outputLine : outputList.subList(index + 1, outputList.size())) {
      String[] outputLineArray = outputLine.trim().split("=");
      if (outputLineArray[0].toLowerCase().equals("transport")) {
        transport = outputLineArray[1];
      }
      if (outputLineArray[0].toLowerCase().equals("target_port_protocols")) {
        targetPort = outputLineArray[1];
      }
    }

    if (transport != null && transport.toLowerCase().equals("sata")) {
      return true;
    } else if (targetPort != null && targetPort.toLowerCase().equals("sata")) {
      return true;
    }
    return false;
  }
}
