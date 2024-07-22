package streamAPI;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class StreamAPI {
  public static void main(String[] args) {
    System.out.println("\n---------Collection Stream 생성---------");
    CreateStream1 createStream1 = new CreateStream1();
    createStream1.createStream();

    System.out.println("\n---------Array Stream 생성---------");
    CreateStream2 createStream2 = new CreateStream2();
    createStream2.createStream();

    System.out.println("\n---------Stream.of Stream 생성---------");
    CreateStream3 createStream3 = new CreateStream3();
    createStream3.createStream();

    System.out.println("\n---------filter Stream 중간 연산---------");
    IntermediateOperationStream1 intermediateOperationStream1 = new IntermediateOperationStream1();
    intermediateOperationStream1.IntermediateOperationStream();

    System.out.println("\n---------map Stream 중간 연산---------");
    IntermediateOperationStream2 intermediateOperationStream2 = new IntermediateOperationStream2();
    intermediateOperationStream2.IntermediateOperationStream();

    System.out.println("\n---------flatMap Stream 중간 연산---------");
    IntermediateOperationStream3 intermediateOperationStream3 = new IntermediateOperationStream3();
    intermediateOperationStream3.IntermediateOperationStream();

    System.out.println("\n---------sorted Stream 중간 연산---------");
    IntermediateOperationStream4 intermediateOperationStream4 = new IntermediateOperationStream4();
    intermediateOperationStream4.IntermediateOperationStream();

    System.out.println("\n---------distinct Stream 중간 연산---------");
    IntermediateOperationStream5 intermediateOperationStream5 = new IntermediateOperationStream5();
    intermediateOperationStream5.IntermediateOperationStream();

    System.out.println("\n---------limit Stream 중간 연산---------");
    IntermediateOperationStream6 intermediateOperationStream6 = new IntermediateOperationStream6();
    intermediateOperationStream6.IntermediateOperationStream();

    System.out.println("\n---------skip Stream 중간 연산---------");
    IntermediateOperationStream7 intermediateOperationStream7 = new IntermediateOperationStream7();
    intermediateOperationStream7.IntermediateOperationStream();

    System.out.println("\n---------forEach Stream 최종 연산---------");
    FinalOperationStream1 finalOperationStream1 = new FinalOperationStream1();
    finalOperationStream1.FinalOperationStream();

    System.out.println("\n---------toArray Stream 최종 연산---------");
    FinalOperationStream2 finalOperationStream2 = new FinalOperationStream2();
    finalOperationStream2.FinalOperationStream();

    System.out.println("\n---------reduce Stream 최종 연산---------");
    FinalOperationStream3 finalOperationStream3 = new FinalOperationStream3();
    finalOperationStream3.FinalOperationStream();

    System.out.println("\n---------collect Stream 최종 연산---------");
    FinalOperationStream4 finalOperationStream4 = new FinalOperationStream4();
    finalOperationStream4.FinalOperationStream();

    System.out.println("\n---------count Stream 최종 연산---------");
    FinalOperationStream5 finalOperationStream5 = new FinalOperationStream5();
    finalOperationStream5.FinalOperationStream();

    System.out.println("\n---------anyMatch Stream 최종 연산---------");
    FinalOperationStream6 finalOperationStream6 = new FinalOperationStream6();
    finalOperationStream6.FinalOperationStream();

    System.out.println("\n---------allMatch Stream 최종 연산---------");
    FinalOperationStream7 finalOperationStream7 = new FinalOperationStream7();
    finalOperationStream7.FinalOperationStream();

    System.out.println("\n---------noneMatch Stream 최종 연산---------");
    FinalOperationStream8 finalOperationStream8 = new FinalOperationStream8();
    finalOperationStream8.FinalOperationStream();
  }
}

class CreateStream1 {
  public void createStream() {
    List<String> list = Arrays.asList("java", "spring", "springBoot", "jpa", "queryDSL");
    Stream<String> stream = list.stream();

    stream.forEach(System.out::println);
  }
}

class CreateStream2 {
  public void createStream() {
    String[] arr = {"java", "spring", "springBoot", "jpa", "queryDSL"};
    Stream<String> stream = Arrays.stream(arr);

    stream.forEach(System.out::println);
  }
}

class CreateStream3 {
  public void createStream() {
    Stream<String> stream = Stream.of("java", "spring", "springBoot", "jpa", "queryDSL");

    stream.forEach(System.out::println);
  }
}

class IntermediateOperationStream1 {
  public void IntermediateOperationStream() {
    System.out.println("filter 조건 : 원소 중 길이 5 이상인 원소 출력");
    Stream<String> stream = Stream.of("java", "spring", "springBoot", "jpa", "queryDSL");
    Stream<String> filterStream = stream.filter(str -> str.length() > 5);

    filterStream.forEach(System.out::println);
  }
}

class IntermediateOperationStream2 {
  public void IntermediateOperationStream() {
    System.out.println("map 조건 : 각 원소 길이만 출력");
    Stream<String> stream = Stream.of("java", "spring", "springBoot", "jpa", "queryDSL");
    Stream<Integer> mapStream = stream.map(String::length);

    mapStream.forEach(System.out::println);
  }
}

class IntermediateOperationStream3 {
  public void IntermediateOperationStream() {
    System.out.println("flatMap 조건 : 두 Stream을 새롭게 생성하고 하나의 Stream으로 병합");
    Stream<List<Integer>> stream = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4));
    Stream<Integer> flatMapStream = stream.flatMap(Collection::stream);

    flatMapStream.forEach(System.out::println);
  }
}

class IntermediateOperationStream4 {
  public void IntermediateOperationStream() {
    System.out.println("sort 조건 : 기본(오름차순) 정렬");
    Stream<String> stream = Stream.of("java", "spring", "springBoot", "jpa", "queryDSL");
    Stream<String> sortStream = stream.sorted();

    sortStream.forEach(System.out::println);
  }
}

class IntermediateOperationStream5 {
  public void IntermediateOperationStream() {
    System.out.println("distinct 조건 : 중복 요소 제거");
    Stream<String> stream = Stream.of("java", "java", "spring", "springBoot", "jpa", "queryDSL");
    Stream<String> distinctStream = stream.distinct();

    distinctStream.forEach(System.out::println);
  }
}

class IntermediateOperationStream6 {
  public void IntermediateOperationStream() {
    System.out.println("limit 조건 : 입력한 파라미터 만큼만 출력");
    Stream<String> stream = Stream.of("java", "spring", "springBoot", "jpa", "queryDSL");
    Stream<String> limitStream = stream.limit(3);

    limitStream.forEach(System.out::println);
  }
}

class IntermediateOperationStream7 {
  public void IntermediateOperationStream() {
    System.out.println("입력한 파리미터 만큼 건너뛰고 출력");
    Stream<String> stream = Stream.of("java", "spring", "springBoot", "jpa", "queryDSL");
    Stream<String> skip = stream.skip(3);

    skip.forEach(System.out::println);
  }
}

class FinalOperationStream1 {
  public void FinalOperationStream() {
    Stream<String> stream = Stream.of("java", "spring", "springBoot", "jpa", "queryDSL");

    stream.forEach(System.out::println);
  }
}

class FinalOperationStream2 {
  public void FinalOperationStream() {
    Stream<String> stream = Stream.of("java", "spring", "springBoot", "jpa", "queryDSL");

    String[] toArrayStream = stream.toArray(String[]::new);
    System.out.println(Arrays.toString(toArrayStream));
  }
}

class FinalOperationStream3 {
  public void FinalOperationStream() {
    Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
    int reduceStream = stream.reduce(0, Integer::sum);

    System.out.println(reduceStream);
  }
}

class FinalOperationStream4 {
  public void FinalOperationStream() {
    Stream<String> stream = Stream.of("java", "spring", "springBoot", "jpa", "queryDSL");
    List<String> collectStream = stream.toList();

    System.out.println(collectStream);
  }
}

class FinalOperationStream5 {
  public void FinalOperationStream() {
    Stream<String> stream = Stream.of("java", "spring", "springBoot", "jpa", "queryDSL");
    long count = stream.count();

    System.out.println(count);
  }
}

class FinalOperationStream6 {
  public void FinalOperationStream() {
    Stream<String> stream = Stream.of("java", "spring", "springBoot", "jpa", "queryDSL");
    boolean anyMatchStream = stream.anyMatch(str -> str.startsWith("j"));

    System.out.println(anyMatchStream);
  }
}

class FinalOperationStream7 {
  public void FinalOperationStream() {
    Stream<String> stream = Stream.of("java", "spring", "springBoot", "jpa", "queryDSL");
    boolean allMatchStream = stream.allMatch(str -> str.length() > 5);

    System.out.println(allMatchStream);
  }
}

class FinalOperationStream8 {
  public void FinalOperationStream() {
    Stream<String> stream = Stream.of("java", "spring", "springBoot", "jpa", "queryDSL");
    boolean noneMatchStream = stream.noneMatch(str -> str.startsWith("k"));

    System.out.println(noneMatchStream);
  }
}

