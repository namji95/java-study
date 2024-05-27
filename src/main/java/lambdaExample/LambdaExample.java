package lambdaExample;

import java.util.function.BiFunction;
import java.util.function.Function;
import javax.xml.transform.Source;

public class LambdaExample {

  public static void main(String[] args) {
    Example example = new Example();
    example.example1();
    example.example2();
    example.example3();
  }
}

class Example {
  public void example1() {
    Function<String, Integer> test = String::length;
    int result = test.apply("가나다라마");
    System.out.println("\n-----------------------Expression 구현-----------------------");
    System.out.println(result);
  }

  public void example2() {
    Runnable runnable = () -> System.out.println("Hello Lambda");
    System.out.println("\n-----------------------매개변수가 없는 경우-----------------------");
    runnable.run();
  }

  public void example3() {
    BiFunction<Integer, Integer, Integer> print = (x, y) -> {
      return x * y;
    };
    int result = print.apply(10, 10);
    System.out.println("\n-----------------------statement 구현-----------------------");
    System.out.println(result);
  }
}
