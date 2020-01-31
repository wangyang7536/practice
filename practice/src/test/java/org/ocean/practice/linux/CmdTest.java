package org.ocean.practice.linux;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class CmdTest {
  public static void main(String[] args) {
    String cmd = "sudo lsscsi -t";
    System.out.println(filter(executeCmd(cmd)).keySet());
    System.out.println(filter(executeCmd(cmd)).values());

    System.out.println(getBlkList());
  }

  public static List<String> getBlkList() {
    String cmd = "sudo lsblk";
    List<String> list = executeCmd(cmd);
    return list;
  }

  public static Map<String, String> filter(List<String> outputList) {
    Map<String, String> filterList = new HashMap<>();
    for (String outputLine : outputList) {
      String[] outputStringArray = outputLine.split("\\s+");
      String transport = outputStringArray[2].trim();
      if (!transport.toLowerCase().contains("sata")) {
        continue;
      }
      String devicePath = outputStringArray[outputStringArray.length - 1].trim();
      String serialNumber = getSerialNumber(devicePath);
      filterList.put(serialNumber, devicePath);
    }
    return filterList;
  }

  private static String getSerialNumber(String path) {
    String cmd = "sudo hdparm -I " + path;
    List<String> outputList = executeCmd(cmd);
    String serialNumber = null;
    for (String outputLine : outputList) {
      if (outputLine.contains("Serial Number")) {
        String[] outputStringArray = outputLine.split(":\\s+");
        serialNumber = outputStringArray[1].trim();
        break;
      }
    }
    return serialNumber;
  }

  public static List<String> executeCmd(String cmd) {
    Objects.requireNonNull(cmd);
    List<String> cmdArgs = new ArrayList<>();
    String[] commandParts = cmd.split("\\s+");
    for (String arg : commandParts) {
      if (arg.length() > 0) {
        cmdArgs.add(arg);
      }
    }
    List<String> result = new ArrayList<>();
    ProcessBuilder processBuilder = new ProcessBuilder(cmdArgs);
    try {
      Process process = processBuilder.start();
      List<String> output = new ArrayList<>();
      try (
          BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
        String line;
        while ((line = br.readLine()) != null) {
          if (!line.isEmpty()) {
            output.add(line);
          }
        }
      } catch (IOException e) {
      }
      result.addAll(output);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return result;
  }
}
