package lambdaExample;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class LambdaClass {

  public static void main(String[] args) {

    List<Integer> list = Arrays.asList(2, 1, 3, 5, 4);

    // 오름차순 정렬
    List<Integer> list2 = list.stream()
        .sorted(Comparator.naturalOrder())
        .collect(Collectors.toList());

    // 내림차순 정렬
    List<Integer> list3 = list.stream()
        .sorted(Comparator.reverseOrder())
        .collect(Collectors.toList());

    System.out.println("-----------------------printList-----------------------");
    printList(list);
    printList(list2);
    printList(list3);

    System.out.println("-----------------------printLambda-----------------------");
    printLambda(list);
    printLambda(list2);
    printLambda(list3);
  }

  private static void printList(List<Integer> list) {

    // 1회용 구현체 new Consumer를 매개변수로 활용
    list.forEach(new Consumer<Integer>() {
      @Override
      public void accept(Integer num) {
        System.out.print(num + " ");
      }
    });
    System.out.println("\n");
  }

  private static void printLambda(List<Integer> list) {

    list.forEach(num -> System.out.print(num + " "));
    System.out.println("\n");
  }

}
