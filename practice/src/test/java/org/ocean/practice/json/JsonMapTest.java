package org.ocean.practice.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonMapTest {
  private static ObjectMapper objectMapper = new ObjectMapper();

  public static void main(String[] args) {
    List<String> rawOutputList = new ArrayList<>();
    rawOutputList.add("[");
    rawOutputList.add("  {");
    rawOutputList.add("    \"dev\":\"namespace0.0\",");
    rawOutputList.add("    \"mode\":\"devdax\",");
    rawOutputList.add("    \"map\":\"mem\",");
    rawOutputList.add("    \"size\":17177772032,");
    rawOutputList.add("    \"uuid\":\"5ff3e18a-6d54-46f1-b3d4-25c51fda602a\",");
    rawOutputList.add("    \"chardev\":\"dax0.0\",");
    rawOutputList.add("    \"align\":2097152");
    rawOutputList.add("  }");
    rawOutputList.add("]");
    TestBean bean1 = new JsonMapTest().function(rawOutputList).get(0);
    System.out.println(bean1.getMode());

    TestBean bean2 = new TestBean();
    bean2.setDev("namespace0.0");
    bean2.setMode("devdax");
    bean2.setMap("mem");
    bean2.setSize(17177772032l);
    bean2.setUuid("5ff3e18a-6d54-46f1-b3d4-25c51fda602a");
    bean2.setChardev("dax0.0");
    bean2.setAlign(2097152);
    String beanString2 = writeObjectAsString(bean2);
    System.out.println(beanString2);

    String emptyString = writeObjectAsString(null);
    System.out.println(emptyString);

    Map<String, String> map = new HashMap<>();
    String mapString = writeObjectAsString(map);
    System.out.println(mapString);

    TypeReference<Map<Long, Long>> typeRef = new TypeReference<Map<Long, Long>>() {};
    Map<Long, Long> targetMap = (Map<Long, Long>) readValueFromString("{}", typeRef);
    System.out.println(targetMap);
  }

  public static Map<Long, Long> readValueFromString(String str, Object obj) {
    Map<Long, Long> result = new HashMap<>();
    try {
      result = objectMapper.readValue(str, Map.class);
    } catch (Exception e) {
      System.out.println("Fail to read value from string");
    }
    return result;
  }

  public static String writeObjectAsString(Object obj) {
    String result = "";
    try {
      result = objectMapper.writeValueAsString(obj);
    } catch (JsonProcessingException e) {
      System.out.println("Fail to write as string");
    }
    return result;
  }

  public List<TestBean> function(List<String> rawOutputList) {
    List<TestBean> resultList = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i < rawOutputList.size() - 1; i++) {
      sb.append(rawOutputList.get(i).trim());
    }
    try {
      TestBean bean = objectMapper.readValue(sb.toString(), TestBean.class);
      resultList.add(bean);
    } catch (Exception e) {
      System.out.println("Fail to map");
    }
    return resultList;
  }
}
