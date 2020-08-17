package org.ocean.practice.uuid;

import java.util.UUID;

public class IdHash {
  public static void main(String[] args) {
    String id = UUID.randomUUID().toString();
    System.out.println(id);
    System.out.println(hashUuid(id));
  }

  public static long hashUuid(String clusterId) {
    String[] components = clusterId.split("-");
    for (int i = 0; i < 5; i++)
      components[i] = "0x" + components[i];
    long hashValue = Long.decode(components[1]).longValue();
    hashValue <<= 48;
    hashValue |= Long.decode(components[4]).longValue();
    System.out.println(Long.toBinaryString(hashValue));
    System.out.println(hashValue);
    long result = hashValue & Long.MAX_VALUE;
    System.out.println(Long.toBinaryString(result));
    return result;
  }

}
