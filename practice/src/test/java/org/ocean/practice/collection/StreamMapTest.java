package org.ocean.practice.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMapTest {
  public static void main(String[] args) {
    List<Box> boxList = new ArrayList<>();
    boxList.add(new Box("1"));
    boxList.add(new Box("2"));
    boxList.add(new Box("3"));

    List<String> indexList =
        boxList.stream().map(box -> box.getIndex()).collect(Collectors.toList());
    System.out.println(indexList);
  }

  static class Box {
    String index;

    public Box(String index) {
      this.index = index;
    }

    public String getIndex() {
      return this.index;
    }
  }
}
