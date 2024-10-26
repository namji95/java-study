package 자료구조;

import java.util.HashMap;

public class GetOrDefault {
  public static void main(String[] args) {
    String[] str = {"a", "b", "c", "d"};

    solutionOne(str);
    solutionTwo(str);
    solutionThree(str);
    solutionfour();
    solutionfive();

  }
  public static void solutionOne(String[] str) {
    HashMap<String, Integer> mapOne = new HashMap<>();

    for (String key: str) {
      mapOne.put(key, mapOne.getOrDefault(key, 0));
    }
    System.out.println("\nkey값이 빈 값이면 0으로 초기화");
    System.out.println("key의 value 값이 빈 값이면 default 값 0 : " + mapOne);
  }
  public static void solutionTwo(String[] str) {
    HashMap<String, Integer> mapTwo = new HashMap<>();

    for (String key: str) {
      mapTwo.put(key, mapTwo.getOrDefault(key, 1));
    }
    System.out.println("\nkey값이 빈 값이면 1으로 초기화");
    System.out.println("key의 value 값이 빈 값이면 default 값 1 : " + mapTwo);
  }
  public static void solutionThree(String[] str) {
    HashMap<String, Integer> mapThree = new HashMap<>();

    for (String key: str) {
      mapThree.put(key, mapThree.getOrDefault(key, 0) + 1);
    }
    System.out.println("\nkey값이 빈 값이면 0으로 초기화 후 1 더하기");
    System.out.println("key의 value 값이 빈 값이면 default 값 1 : " + mapThree);
  }
  public static void solutionfour() {
    HashMap<String, Integer> mapFour = new HashMap<>();
    String[] str = {"a", "b", "c", "d", "d"};

    for (String key: str) {
      mapFour.put(key, mapFour.getOrDefault(key, 0));
    }
    System.out.println("\nkey값이 빈 값이면 0으로 초기화 동일한 key 값이 존재해도 0으로 초기화");
    System.out.println("key의 value 값이 빈 값이면 default 값 1 : " + mapFour);
  }
  public static void solutionfive() {
    HashMap<String, Integer> mapFive = new HashMap<>();
    String[] str = {"a", "b", "c", "d", "d"};

    for (String key: str) {
      mapFive.put(key, mapFive.getOrDefault(key, 0) + 1);
    }
    System.out.println("\nkey값이 빈 값이면 0으로 초기화 후 1 더하기 동일한 key 값이 존재해도 0으로 초기화 후 1 더하기");
    System.out.println("key의 value 값이 빈 값이면 default 값 1 : " + mapFive);
  }
}