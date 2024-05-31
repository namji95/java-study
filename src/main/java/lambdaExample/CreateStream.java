package lambdaExample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Parameter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreateStream {

  public static void main(String[] args) {
    System.out.println("\n------------------빈 스트림 생성------------------");
    EmptyStream emptyStream = new EmptyStream();
    emptyStream.emptyStream();

    System.out.println("\n------------------매개변수로 스트림 생성------------------");
    ParameterStream parameterStream = new ParameterStream();
    parameterStream.parameterStream();

    System.out.println("\n------------------null이 될 수 있는 개체 스트림화------------------");
    NullStream nullStream = new NullStream();
    nullStream.nullStream();

    System.out.println("\n------------------배열로 스트림 생성------------------");
    ArrayStream arrayStream = new ArrayStream();
    arrayStream.arrayStream();

    System.out.println("\n------------------파일로 스트림 생성------------------");
    FileStream fileStream = new FileStream();
    fileStream.fileStream();

    System.out.println("\n------------------함수형 인터페이스 스트림 생성------------------");
    IterateStream iterateStream = new IterateStream();
    iterateStream.interateStream();

    System.out.println("\n------------------함수형 인터페이스 스트림 생성2------------------");
    GenerateStream generateStream = new GenerateStream();
    generateStream.generateStream();
  }
}

class GenerateStream {
  public void generateStream () {
    Random random = new Random();

    System.out.println("generate를 이용해 로또 번호 생성해보기");
    IntStream.generate(() -> random.nextInt(45) + 1)
        .limit(6)
        .forEach(System.out::println);
  }
}

class IterateStream {
  public void interateStream () {
    System.out.println("초기값, 조건 형식의 iterate");
    Stream.iterate(0, n -> n + 1)
        .limit(5)
        .forEach(System.out::print);

    System.out.println("\n초기값, 조건, 조건 형식의 iterate");
    Stream.iterate(0, n -> n < 5, n -> n + 1)
        .forEach(System.out::print);
  }
}

class FileStream {
  public void fileStream () {
    Stream<String> fileStream = new BufferedReader(new InputStreamReader(
        Objects.requireNonNull(getClass().getResourceAsStream("/streamTest.txt"))))
        .lines();

    fileStream
        .flatMap(line -> Stream.of(line.split(" ")))
        .forEach(System.out::println);
  }
}

class ArrayStream {
  public void arrayStream () {
    int[] num = {1, 2, 3, 4, 5};

    IntStream intStream = Arrays.stream(num); // intStream 생성

    Stream<Integer> numStream = intStream.boxed(); // Stream<Integer>로 변환

    System.out.println(numStream.collect(Collectors.toList()));
  }
}

class NullStream {
  public void nullStream () {
    Map<String, List<Integer>> map = new HashMap<>();
    map.put("한자리", Arrays.asList(1, 2, 3, 4, 5));
    map.put("두자리", Arrays.asList(10));
    map.put("세자리", Arrays.asList(100, 200, 300));

    Stream<String> searchNum =
        Stream.ofNullable(map.get("한자리").stream()
            .map(Object::toString)
            .collect(Collectors.joining()));

    System.out.println("null이 아닌 객체 스트림화 : " + searchNum.collect(Collectors.toList()));

    Stream<String> searchNumber = Stream.ofNullable(map.get("네자리"))
        .flatMap(list -> Stream.of(list.stream()
            .map(Object::toString)
            .collect(Collectors.joining())));

    System.out.println("null인 객체 스트림화 : " + searchNumber.collect(Collectors.toList()));
  }
}

class ParameterStream {
  public void parameterStream () {
    Stream<Integer> parameterStream =
        Stream.of(1, 2, 3, 4, 5);

    System.out.println("매개변수를 이용한 스트림 생성 : " + parameterStream.collect(Collectors.toList()));
  }
}

class EmptyStream {
  public void emptyStream () {
    Stream<String> emptyStream = Stream.empty();

    System.out.println("빈 스트림 : " + emptyStream.collect(Collectors.toList()));
  }
}
