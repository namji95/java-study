import java.lang.module.FindException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionalProgrammingExample {

  public static void main(String[] args) {
    System.out.println("자바의 Stream API를 사용한 함수형 프로그래밍");
    System.out.println(streamEx1() + "\n");
    System.out.println("자바에서의 고차 함수");
    System.out.println(higherOrderFunction() + "\n");
//    System.out.println("자바에서 Runnable 인터페이스의 구현");
//    System.out.println(runnableEx1() + "\n");
//    System.out.println("자바에서 Runnable 인터페이스 람다식 표현");
//    System.out.println(runnableEx2() + "\n");
    System.out.println("함수 조합");
    System.out.println(Math1() + "\n");
    System.out.println("자바 Stream API를 이용한 병렬 처리");
    System.out.println(streamParallelProcessing() + "\n");
    System.out.println("자바의 Optional 클래스 사용");
    System.out.println(OptionalEx1() + "\n");
    System.out.println("Currying(커링) 테스트");
    System.out.println(curryingEx() + "\n");
    System.out.println("추상화된 함수형 프로그래밍");
    System.out.println(streamEx2() + "\n");
  }

  // 자바의 Stream API를 사용한 함수형 프로그래밍
  public static List<String> streamEx1 () {
    List<String> names = Arrays.asList("John", "Jane", "Anna", "Mike");
    return names.stream()
        .filter(name -> name.length() > 3)
        .map(String::toUpperCase)
        .collect(Collectors.toList());
  }

  // 자바에서의 고차 함수
  public static String higherOrderFunction() {
    Function<String, Integer> getLength1 = str -> str.length();
    Function<String, Integer> getLength2 = String::length;
    int length1 = getLength1.apply("Higher Function");
    int length2 = getLength2.apply("Higher Order Function");

    return "length1 : " + length1 + ", " + "length2 : " + length2;
  }

  // 자바에서 Runnable 인터페이스의 구현
  public static String runnableEx1() {
    new Thread(new Runnable() {
      @Override
      public void run() {
        System.out.println("Tread is Running");
      }
    }).start();
    return "Runnable 인터페이스 구현";
  }

  // 자바에서 Runnable 인터페이스 람다식 표현
  public static String runnableEx2() {
    new Thread(() -> System.out.println("Thread is Lambda Running")).start();
    return "Runnable 인터페이스 람다식 표현";
  }

  // 함수 조합
  public static int Math1() {
    Function<Integer, Integer> multiply = num1 -> num1 * 2;
    Function<Integer, Integer> add = num2 -> num2 + 3;

    Function<Integer, Integer> composedFunction = multiply.andThen(add);

    return composedFunction.apply(4);
  }

  // 자바 Stream API를 이용한 병렬 처리
  public static int streamParallelProcessing() {
    List<Integer> numList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

    return numList.parallelStream()
        .filter(num -> num % 2 == 0)
        .mapToInt(Integer::intValue)
        .sum();
  }

  // 자바의 Optional 클래스 사용
  public static Optional<String> OptionalEx1() {
    Optional<String> optionalValue = Optional.of("Hello, Namji");
    optionalValue = optionalValue.map(String::toUpperCase);
    return optionalValue;
  }

  // 커링
  public static int curryingEx() {
//    BiFunction<Integer, Integer, Integer> add = (x, y) -> x + y;
//    BiFunction<Integer, Integer, Integer> add = Integer::sum;

    Function<Integer, Function<Integer, Integer>> curriedAdd = x -> y -> x + y;

    Function<Integer, Integer> add2 = curriedAdd.apply(5);

    return add2.apply(3);
  }

  // 자바의 Stream API를 사용한 함수형 프로그래밍
  public static List<String> streamEx2 () {
    List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");
    return names.stream()
        .filter(name -> name.length() > 4)
        .map(String::toUpperCase)
        .collect(Collectors.toList());
  }

}
