package org.ocean.practice.string;

import java.util.ArrayList;
import java.util.List;

public class StringSplitTest {
  public static void main(String[] args) {
    String line = "[2:0:0:0]    disk    sas:0x1221000005000000          /dev/sda  ";
    List<String> outputList = new ArrayList<>();
    outputList.add("[2:0:0:0]    disk    sas:0x1221000005000000          /dev/sda ");
    outputList.add("  transport=sas");
    outputList.add("  vendor=ATA  ");
    outputList.add("  model=WDC  WDS500G2B0A");
    outputList.add("  bay_identifier=5");
    outputList.add("  enclosure_identifier=0x5d4ae5208db86000");
    outputList.add("  initiator_port_protocols=none");
    outputList.add("  initiator_response_timeout=0");
    outputList.add("  I_T_nexus_loss_timeout=0");
    outputList.add("  phy_identifier=5");
    outputList.add("  ready_led_meaning=0");
    outputList.add("  sas_address=0x1221000005000000");
    outputList.add("  target_port_protocols=sata");
    outputList.add("  tlr_enabled=0");
    outputList.add("  tlr_supported=0");
    outputList.add("[0:0:0:0]    cd/dvd  ata:                            /dev/sr0  ");
    outputList.add("  transport=sata");
    function(line.trim(), outputList);
  }

  public static void function(String line, List<String> outputList) {
    int index = 0;
    for (int i = 0; i < outputList.size(); i++) {
      if (outputList.get(i).trim().equals(line)) {
        index = i;
        break;
      }
    }
    System.out.println(index);
    String transport = null;
    String targetPort = null;
    boolean findTransport = false;
    for (String outputLine : outputList.subList(index + 1, outputList.size())) {
      String[] outputLineArray = outputLine.trim().split("=");
      if (findTransport && outputLineArray[0].toLowerCase().equals("transport")) {
        System.out.println("Only can have one transport!");
        return;
      }
      if (!findTransport && outputLineArray[0].toLowerCase().equals("transport")) {
        findTransport = true;
        transport = outputLineArray[1];
        if (transport != null && transport.toLowerCase().equals("sata")) {
          System.out.println("this is a Sata device and transport is sata");
          return;
        }
      }
      if (outputLineArray[0].toLowerCase().equals("target_port_protocols")) {
        targetPort = outputLineArray[1];
        if (targetPort != null && targetPort.toLowerCase().equals("sata")) {
          System.out.println("this is a Sata device and targetPortProtocols is sata");
          return;
        }
        break;
      }
    }
  }
}
