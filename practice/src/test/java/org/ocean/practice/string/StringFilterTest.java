package org.ocean.practice.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringFilterTest {
  public static void main(String[] args) {
    List<String> blkList = new ArrayList<>();
    blkList.add("sdb                    8:16   0 894.3G  0 disk ");
    blkList.add("sdc                    8:32   0 136.8G  0 disk ");
    blkList.add("sda                    8:0    0 232.9G  0 disk ");
    blkList.add("├─sda2                 8:2    0     1K  0 part ");
    blkList.add("├─sda5                 8:5    0 232.4G  0 part ");
    blkList.add("│ ├─hcd85--vg-swap_1 253:1    0   976M  0 lvm  [SWAP]");
    blkList.add("│ └─hcd85--vg-root   253:0    0 231.4G  0 lvm  /");
    blkList.add("└─sda1                 8:1    0   487M  0 part /boot");

    Map<String, String> dList = new HashMap<>();
    dList.put("180506A03873", "sda");
    dList.put("Z4JS104VTM9W", "sdc");
    function(blkList, dList);
  }

  public static void function(List<String> blkList, Map<String, String> dList) {
    String deviceNodeName = null;
    for (int i = 0; i < blkList.size(); i++) {
      String outputLine = blkList.get(i);

      String[] outputStringArray = outputLine.split("\\s+");
      String firstWord = outputStringArray[0].trim();
      if ("disk".equals(outputStringArray[5].trim())) {
        deviceNodeName = firstWord;
      } else if ("part".equals(outputStringArray[5].trim())) {
        assert !Character.isLetterOrDigit(firstWord.charAt(0));
      } else if ("lvm".equals(outputStringArray[outputStringArray.length - 2].trim())) {
        assert !Character.isLetterOrDigit(firstWord.charAt(0));
      } else {
        continue;
      }
      assert deviceNodeName != null;
      if (dList.containsValue(deviceNodeName)) {
        if ("/".equals(outputStringArray[outputStringArray.length - 1].trim())) {
          System.out.println(deviceNodeName + " is mounter on root");
        }
      }
    }

  }
}
