package org.ocean.practice.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamFunctionSample {
  public static void main(String[] args) {
    Set<Dish> set = new HashSet<>();
    set.add(new Dish("apple", 50));
    set.add(new Dish("orange", 30));
    set.add(new Dish("banana", 80));
    System.out.println(new StreamFunctionSample().nonFunctional(set));
    System.out.println(new StreamFunctionSample().functional(set));
  }

  static class Dish {
    private String name;
    private int calory;

    public Dish(String name, int calory) {
      this.name = name;
      this.calory = calory;
    }

    public int getCalory() {
      return this.calory;
    }

    public String getName() {
      return this.name;
    }
  }

  public List<String> nonFunctional(Set<Dish> set) {
    List<Dish> dishList = new ArrayList<>();
    for (Dish d : set) {
      if (d.getCalory() > 10) {
        dishList.add(d);
      }
    }
    Collections.sort(dishList, new Comparator<Dish>() {
      @Override
      public int compare(Dish d1, Dish d2) {
        return d1.getName().compareTo(d2.getName());
      }
    });

    List<String> dishNameList = new ArrayList<>();
    for (Dish d : dishList) {
      dishNameList.add(d.getName());
    }

    return dishNameList;
  }

  public List<String> functional(Set<Dish> set) {
    return set.stream().filter(d -> d.getCalory() > 10).sorted(Comparator.comparing(Dish::getName))
        .map(Dish::getName).collect(Collectors.toList());
  }
}
