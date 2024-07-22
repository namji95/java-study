package streamAPI;

import java.util.*;
import java.util.stream.Collectors;

public class StreamAPIUtilization {
  public static void main(String[] args) {
    List<String> list = Arrays.asList("java", "spring", "springBoot", "jpa", "queryDSL");
    List<Integer> numList = Arrays.asList(1, 2, 3, 4, 5);

    System.out.println("\n---------스트림에서 요소 찾기---------");
    StreamAPI1 streamAPI1 = new StreamAPI1();
    streamAPI1.streamAPI(list);

    System.out.println("\n---------스트림에서 요소 수집---------");
    StreamAPI2 streamAPI2 = new StreamAPI2();
    streamAPI2.streamAPI(list);

    System.out.println("\n---------스트림에서 요소 집계---------");
    StreamAPI3 streamAPI3 = new StreamAPI3();
    streamAPI3.streamAPI(numList);

    System.out.println("\n---------스트림에서 요소 그룹화---------");
    StreamAPI4 streamAPI4 = new StreamAPI4();
    streamAPI4.streamAPI();

    System.out.println("\n---------스트림 병렬 처리---------");
    StreamAPI5 streamAPI5 = new StreamAPI5();
    streamAPI5.streamAPI(list);

    System.out.println("\n---------스트림 Optional 활용---------");
    StreamAPI6 streamAPI6 = new StreamAPI6();
    streamAPI6.streamAPI();

    System.out.println("\n---------스트림 배열 변환---------");
    StreamAPI7 streamAPI7 = new StreamAPI7();
    streamAPI7.streamAPI(list);

    System.out.println("\n---------스트림 모든 요소 처리---------");
    StreamAPI8 streamAPI8 = new StreamAPI8();
    streamAPI8.streamAPI(list);

    System.out.println("\n---------스트림 값 추출---------");
    StreamAPI9 streamAPI9 = new StreamAPI9();
    streamAPI9.streamAPI(numList);

    System.out.println("\n---------스트림 중복 제거---------");
    StreamAPI10 streamAPI10 = new StreamAPI10();
    streamAPI10.streamAPI();

    System.out.println("\n---------스트림 요소 분할---------");
    StreamAPI11 streamAPI11 = new StreamAPI11();
    streamAPI11.streamAPI(numList);

    System.out.println("\n---------스트림 요소 정렬---------");
    StreamAPI12 streamAPI12 = new StreamAPI12();
    streamAPI12.streamAPI();

    System.out.println("\n---------스트림 요소 제한---------");
    StreamAPI13 streamAPI13 = new StreamAPI13();
    streamAPI13.streamAPI(numList);

    System.out.println("\n---------스트림 요소 건너뛰기---------");
    StreamAPI14 streamAPI14 = new StreamAPI14();
    streamAPI14.streamAPI(numList);

    System.out.println("\n---------스트림 요소 매핑---------");
    StreamAPI15 streamAPI15 = new StreamAPI15();
    streamAPI15.streamAPI(list);

    System.out.println("\n---------스트림 요소 집계---------");
    StreamAPI16 streamAPI16 = new StreamAPI16();
    streamAPI16.streamAPI(numList);

    System.out.println("\n---------스트림 요소 카운트---------");
    StreamAPI17 streamAPI17 = new StreamAPI17();
    streamAPI17.streamAPI(numList);

    System.out.println("\n---------스트림 요소 변환---------");
    StreamAPI18 streamAPI18 = new StreamAPI18();
    streamAPI18.streamAPI(list);
  }
}

class StreamAPI1 {
  public void streamAPI(List<String> list) {
    Optional<String> findElement =
        list.stream()
            .filter(s -> s.startsWith("j"))
            .findFirst();

    findElement.ifPresent(System.out::println);
  }
}

class StreamAPI2 {
  public void streamAPI(List<String> list) {
    List<String> collectElement =
        list.stream()
            .filter(s -> s.startsWith("j"))
            .toList();

    System.out.println(collectElement);
  }
}

class StreamAPI3 {
  public void streamAPI(List<Integer> numList) {
    int aggregationElement = numList.stream().reduce(0, Integer::sum);

    System.out.println(aggregationElement);
  }
}

class StreamAPI4 {
  public void streamAPI() {
    List<Classes> classes = Arrays.asList(
        new Classes("Java", 1),
        new Classes("Spring", 2),
        new Classes("SpringBoot", 3),
        new Classes("JPA", 4),
        new Classes("QueryDSL", 5));

    Map<String, List<Classes>> groupElement = classes.stream().collect(Collectors.groupingBy(Classes::getSubject));
    System.out.println(groupElement);
  }
}

class Classes {
  private final String subject;
  private final int period;

  public Classes(String subject, int period) {
    this.subject = subject;
    this.period = period;
  }

  public String getSubject() {
    return subject;
  }

  public int getPeriod() {
    return period;
  }

  @Override
  public String toString() {
    return "Classes [subject=" + subject + ", period=" + period + "]";
  }
}

class StreamAPI5 {
  public void streamAPI(List<String> list) {
    long parallel = list.parallelStream().filter(s -> s.startsWith("j")).count();

    System.out.println(parallel);
  }
}

class StreamAPI6 {
  public void streamAPI() {
    Optional<String> optional = Optional.of("Java");
    if (optional.isPresent()) {
      String result = optional.get();
      System.out.println(result);
    } else {
      System.out.println("No Value");
    }
  }
}

class StreamAPI7 {
  public void streamAPI(List<String> list) {
    String[] conversionArray = list.toArray(String[]::new);

    System.out.println(Arrays.toString(conversionArray));
  }
}

class StreamAPI8 {
  public void streamAPI(List<String> list) {
    list.forEach(System.out::println);
  }
}

class StreamAPI9 {
  public void streamAPI(List<Integer> numList) {
    int valueExtraction =
        numList.stream()
            .mapToInt(Integer::intValue)
            .sum();

    System.out.println(valueExtraction);
  }
}

class StreamAPI10 {
  public void streamAPI() {
    List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5, 1);
    List<Integer> deduplication =
        arr.stream()
            .distinct()
            .toList();

    System.out.println(deduplication);
  }
}

class StreamAPI11 {
  public void streamAPI(List<Integer> numList) {
    Map<Boolean, List<Integer>> splitElements =
        numList.stream()
            .collect(Collectors.partitioningBy(i -> i % 2 == 0));

    System.out.println(splitElements);
  }
}

class StreamAPI12 {
  public void streamAPI() {
    List<Integer> list = Arrays.asList(5, 1, 3, 2, 4);
    List<Integer> sortElement =
        list.stream()
            .sorted()
            .toList();

    System.out.println(sortElement);
  }
}

class StreamAPI13 {
  public void streamAPI(List<Integer> numList) {
    List<Integer> limitElement =
        numList.stream()
            .limit(3)
            .toList();

    System.out.println(limitElement);
  }
}

class StreamAPI14 {
  public void streamAPI(List<Integer> numList) {
    List<Integer> skipElement =
        numList.stream()
            .skip(3)
            .toList();

    System.out.println(skipElement);
  }
}

class StreamAPI15 {
  public void streamAPI(List<String> list) {
    List<String> mappingElement =
        list.stream()
            .flatMap(s -> Arrays.stream(s.split("")))
            .distinct()
            .toList();

    System.out.println(mappingElement);
  }
}

class StreamAPI16 {
  public void streamAPI(List<Integer> numList) {
    IntSummaryStatistics aggregationElement =
        numList.stream()
            .mapToInt((x) -> x)
            .summaryStatistics();

    System.out.println(aggregationElement);
  }
}

class StreamAPI17 {
  public void streamAPI(List<Integer> numList) {
    long countStream =
        numList.stream()
            .count();

    System.out.println(countStream);
  }
}

class StreamAPI18 {
  public void streamAPI(List<String> list) {
    List<String> conversionElement =
        list.stream()
            .map(String::toUpperCase)
            .toList();

    System.out.println(conversionElement);
  }
}