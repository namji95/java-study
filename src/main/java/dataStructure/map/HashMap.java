package dataStructure.map;

import org.springframework.web.servlet.resource.CssLinkResourceTransformer;

import java.util.*;

public class HashMap {
  public static void main(String[] args) {
    Map<String, String> map = new java.util.HashMap<>();

    map.put("java", "01101010 01100001 01110110 01100001");
    map.put("html", "01101000 01110100 01101101 01101100");
    map.put("css", "01100011 01110011 01110011");
    map.put("javascript", "01101010 01100001 01110110 01100001 01110011 01100011 01110010 01101001 01110000 01110100");
    map.put("python", "01110000 01111001 01110100 01101000 01101111 01101110");

    System.out.println("\nmap 변수를 entrySet을 이용하여 key value 값 불러오는 방법");
    mapEntrySet(map);

    System.out.println("\nmap 변수를 forEach를 이용하여 key value 값 불러오는 방법");
    mapForEach(map);

    System.out.println("\nmap 변수를 Stream, forEach를 이용하여 key value 값 불러오는 방법");
    mapStreamForEach(map);

    System.out.println("\nmap에서 key 값만 불러오는 방법");
    mapKey(map);

    System.out.println("\nmap에서 value 값만 불러오는 방법");
    mapValue(map);

    System.out.println("\n");
    mapContains(map);
  }

  private static void mapEntrySet(Map<String, String> map) {
    for (Map.Entry<String, String> entry : map.entrySet()) {
      System.out.println(entry.getKey() + " 2진수 변환: " + entry.getValue());
    }
  }

  private static void mapForEach(Map<String, String> map) {
    Iterator<Map.Entry<String, String>> iter = map.entrySet().iterator();

    while (iter.hasNext()) {
      Map.Entry<String, String> entry = iter.next();
      System.out.println(entry.getKey() + " 2진수 변환: " + entry.getValue());
    }
  }

  private static void mapStreamForEach(Map<String, String> map) {
    map.forEach((k, v) -> System.out.println(String.format("%s 2진수 변환: %s", k, v)));
  }

  private static void mapKey(Map<String, String> map) {
    for (String key : map.keySet()) {
      System.out.println(key + " ");
    }
  }

  private static void mapValue(Map<String, String> map) {
    for (String value : map.values()) {
      System.out.println(value + " ");
    }
  }

  private static void mapContains(Map<String, String> map) {
    boolean trueContains = map.containsKey("java");
    boolean falseContains = map.containsKey("jaba");

    System.out.println("containsKey(\"java\"): " + trueContains + " | containsKey(\"jaba\"): " + falseContains);
  }
}