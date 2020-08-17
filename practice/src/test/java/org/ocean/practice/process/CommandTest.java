package org.ocean.practice.process;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class CommandTest {
  public static void main(String[] args) {
    String cmd = "sudo lsscsi";
    List<String> arguments = commandParser(cmd);
    try {
      executeCmd(arguments);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void executeCmd(List<String> arguments) throws Exception {
    ProcessBuilder processBuilder = new ProcessBuilder(arguments);
    Process process = processBuilder.start();
    if (!process.waitFor(10, TimeUnit.MINUTES)) {
      throw new Exception("Failed to execute command: " + arguments.toString());
    }
    System.out.println(process.exitValue());
  }

  private static List<String> commandParser(String command) {
    Objects.requireNonNull(command);
    List<String> args = new ArrayList<>();
    String[] commandParts = command.split("\\s+");
    for (String arg : commandParts) {
      if (arg.length() > 0) {
        args.add(arg);
      }
    }
    return args;
  }
}
